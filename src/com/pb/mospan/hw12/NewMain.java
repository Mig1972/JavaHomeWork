package com.pb.mospan.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.mospan.hw11.*;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class NewMain {
    public static void main(String[] args) throws Exception {

        String phoneBookJson;
        int index;

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());

        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);


        List<PhoneBook> phoneBookList = new ArrayList<>();

        phoneBookList.add (new PhoneBook("Мосьпан Ирина",
                LocalDate.of(1972,10,27),
                Arrays.asList("0681838782","0638445700","0504587872"),
                "Днепр"));
        phoneBookList.add (new PhoneBook("Кацалап Виктор",
                LocalDate.of(1973,5,30),
                Arrays.asList("0985402982","09712345"),
                "Кременчуг"));
        phoneBookList.add (new PhoneBook("Мосьпан Геннадий",
                LocalDate.of(1949,8,27),
                Arrays.asList("0681838780","063123132"),"Каменское"));



        Scanner scan = new Scanner(System.in);
        System.out.println("Программа ТЕЛЕФОННЫЙ СПРАВОЧНИК");
        System.out.println("-----------------------------------------------");

        while (true) {
            System.out.println("ОСНОВНОЕ МЕНЮ:");
            System.out.println("- Вывести на экран данные справочника         - нажмите 1");
            System.out.println("- Для добавления новой записи                 - нажмите 2");
            System.out.println("- Для удаления записи                         - нажмите 3");
            System.out.println("- Для поиска необходимой записи               - нажмите 4");
            System.out.println("- Для сортировки справочника по ФИО           - нажмите 5");
            System.out.println("- Для сортировки справочника по дате рождения - нажмите 6");
            System.out.println("- Для редактирования записи                   - нажмите 7");
            System.out.println("- Для записи Справочника в файл               - нажмите 8");
            System.out.println("- Для загрузки из файла всех записей          - нажмите 9");
            System.out.println("- Выйти из справочника                        - нажмите 0");
            System.out.println("Введите число:");

            String option = scan.next();

            switch (option) {
                case "1":
                    phoneBookJson = mapper.writeValueAsString(phoneBookList);
                    System.out.println("Выводим все записи телефонного справочника:");
                    System.out.println(phoneBookJson);
                    System.out.println("----------------------------------------");
                    break;

                case "2":
                    phoneBookList.add(addElement(scan));
                    System.out.println("Успешно добавлена запись");
                    System.out.println("----------------------------------------");
                    break;

                case "3":
                    System.out.println("Введите ФИО абонента для удаления: ");
                    String str= scanner(scan);

                    List<PhoneBook> phoneList = phoneBookList.stream()
                            .filter(p -> p.getFio().equals(str))
                            .collect(Collectors.toList());

                    phoneBookList.removeAll(phoneList);

                    if (phoneList.isEmpty())
                    {System.out.println("Ошибка: запись с ФИО " + str + " не существует.");}
                    else {System.out.println("Запись с ФИО " + str + " успешно удалена.");}

                    System.out.println("----------------------------------------");
                    break;

                case "4":
                    System.out.println("Введите ФИО абонента для поиска: ");
                    str= scanner(scan);

                    phoneList = phoneBookList.stream()
                            .filter(p -> p.getFio().equals(str))
                            .collect(Collectors.toList());

                    System.out.println (phoneList);

                    if (phoneList.isEmpty())
                    {System.out.println("Ошибка: запись с ФИО " + str + " не существует.");}

                    System.out.println("----------------------------------------");
                    break;

                case "5":
                    phoneBookList.stream()
                            .sorted(Comparator.comparing(PhoneBook::getFio))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    System.out.println("----------------------------------------");
                    break;

                case "6":
                    phoneBookList.stream()
                            .sorted(Comparator.comparing(PhoneBook::getDateOfBirth))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    System.out.println("----------------------------------------");
                    break;

                case "7":
                    edit(scan, phoneBookList);
                    System.out.println("----------------------------------------");
                    break;

                case "8":
                    FileWriter file = new FileWriter("phonebook.json");
                    phoneBookJson = mapper.writeValueAsString(phoneBookList);
                    file.append(phoneBookJson);
                    file.flush();
                    file.close();

                    System.out.println("Запись в файл прошла успешно.");
                    System.out.println("----------------------------------------");
                    break;

                case "9":
                    phoneBookList = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get("phonebook.json").toFile(), PhoneBook[].class)));
                    phoneBookJson = mapper.writeValueAsString(phoneBookList);
                    System.out.println(phoneBookJson);
                    System.out.println("----------------------------------------");
                    break;

                case "0":
                    System.out.println("Программа успешно завершила свою работу!");
                    return;
                default:
                    System.out.println("Вы ввели неизвестный оператор!");
            }
        }

    }

    private static PhoneBook addElement(Scanner scan) {
        String str = scan.nextLine();

        // Добавление ФИО
        System.out.println("Введите ФИО: ");
        String fio = scan.nextLine();

        // Добавление даты рождения
        System.out.println("Введите дату рождения в формате dd/MM/yyyy: ");
        LocalDate dateOfBirth = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        // Добавление номеров телефона
        int i=1; int j=1;
        List <String> phones = new ArrayList<>();
        System.out.println("Введите телефон №"+i+":");
        String phone = scan.nextLine();
        phones.add(phone);

        do{
            System.out.println("Если хотите добавить еще один номер телефона - введите 1");
            System.out.println("Если вы закончили добавлять номера телефонов - введите 0");
            System.out.println("Введите число:");


            String option = scan.next();
            //System.out.println("option = "+ option);
            switch (option) {
                case "0":
                    System.out.println("Добавление телефонных номеров закончено");
                    j=0;
                    break;
                case "1":
                    i++;
                    System.out.println("Введите телефон №"+i+":");
                    phone = scan.next();
                    phones.add(phone); break;
                default:
                    System.out.println("Вы ввели неизвестный элемент!");
            }}
        while (j!=0);


        // Добавление адреса
        System.out.println("Введите адрес: ");
        String address = scan.next();

        // Добавление новой записи
        PhoneBook phoneBook = new PhoneBook(fio, dateOfBirth, phones, address);
        return phoneBook;
    }

    private static String scanner(Scanner scan) {
        String str = scan.nextLine();
        return scan.nextLine();
    }

    private static int getIndex (String str, List <PhoneBook> phone)
    {
        List <String> FIO = new ArrayList<>();
        int index = -1;

        for (PhoneBook i : phone) {
            if (i.getFio().equals(str)) {
                index = phone.indexOf(i);
            }
        }
        return index;
    }


    private static void edit(Scanner scan, List<PhoneBook> phoneBookList) {

        int i=0;

        System.out.println("Введите ФИО абонента для редактирование: ");
        String str= scanner(scan);
        int index = getIndex(str, phoneBookList);

        if (index==-1)
        {System.out.println("Ошибка: запись c ФИО абонента " + str + " не существует.");}
        else
        {PhoneBook phoneBook = phoneBookList.get(index);
            do {
                System.out.println();
                System.out.println("- Для редактирования ФИО            - нажмите 1");
                System.out.println("- Для редактирования даты рождения  - нажмите 2");
                System.out.println("- Для редактирования телефона       - нажмите 3");
                System.out.println("- Для редактирования адреса         - нажмите 4");
                System.out.println("- Для возврата в Главное меню       - нажмите 0");
                System.out.println("Введите число:");


                String option = scan.next();

                switch (option) {
                    case "1":
                        System.out.println("Запись с индексом " + index + ":  ");
                        System.out.println("Текущее ФИО- "+ phoneBook.getFio());
                        System.out.println("Введите новое ФИО:");
                        phoneBook.setFio(scanner(scan));
                        phoneBookList.set(index, phoneBook);
                        System.out.println("Данные отредактированы");
                        break;
                    case "2":
                        System.out.println("Запись с индексом " + index + ":  ");
                        System.out.println("Текущее ФИО: "+ phoneBook.getFio());
                        System.out.println("Текущая дата рождения: "+ phoneBook.getDateOfBirth());
                        System.out.println("Введите новую дату в формате dd/MM/yyyy :");
                        phoneBook.setDateOfBirth(LocalDate.parse(scanner(scan), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        phoneBookList.set(index, phoneBook);
                        System.out.println("Данные отредактированы");
                        break;
                    case "3":
                        List <String> phones = new ArrayList<>();
                        phones = phoneBook.getPhone();

                        System.out.println("Запись с индексом " + index + ":  ");
                        System.out.println("Текущее ФИО: "+ phoneBook.getFio());
                        System.out.println("Текущие номера телефонов: "+ phoneBook.getPhone());

                        int j=1;

                        do {
                            System.out.println("Если хотите добавить еще один номер телефона            - нажмите 1");
                            System.out.println("Если хотите отредактировать существующий номер телефона - нажмите 2");
                            System.out.println("Если вы закончили изменять номера телефонов             - нажмите 0");
                            System.out.println("Введите число:");

                            option = scan.next();
                            switch (option) {
                                case "0":
                                    System.out.println("Изменение телефонных номеров закончено");
                                    j = 0;
                                    break;

                                case "1":
                                    System.out.println("Введите новый номер телефона:");
                                    String phone = scanner(scan);
                                    phones.add(phone);
                                    System.out.println("Новый номер телефона добавлен.");
                                    break;

                                case "2":
                                    System.out.println("Введите номер телефона, который вы хотите отредактировать: ");
                                    phone = scan.next();

                                    if (phones.indexOf(phone) != -1) {
                                        i = phones.indexOf(phone);
                                        System.out.println("Введите новый номер телефона:");
                                        phone = scan.next();
                                        phones.set(i, phone);
                                        System.out.println("Данные отредактированы");
                                    } else {
                                        System.out.println("Такого телефона в списке нет!");
                                    }
                                    break;
                                default:  System.out.println("Ошибочный оператор");
                                    break;
                            }
                        }
                        while (j != 0) ;
                        break;

                    case "4":
                        System.out.println("Запись с индексом " + index + ":  ");
                        System.out.println("текущее ФИО: "+ phoneBook.getFio());
                        System.out.println("Текущий адрес: "+ phoneBook.getAddress());
                        System.out.println("Введите новый адрес:");
                        phoneBook.setAddress(scanner(scan));
                        phoneBookList.set(index, phoneBook);
                        System.out.println("Данные отредактированы");
                        break;
                    case "0":
                    { i=1; break;}
                    default:
                        System.out.println("Ошибка ввода выбора действия.");
                }}
            while (i!=1);
        }

    }}
