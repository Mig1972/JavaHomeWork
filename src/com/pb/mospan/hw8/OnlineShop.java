package com.pb.mospan.hw8;

import java.util.Scanner;

public class OnlineShop  {
    public static void main(String[] args)
            throws WrongLoginException, WrongPasswordException  {
        Auth user = new Auth();
        Scanner in = new Scanner(System.in);
        int i=0;

        do {
            i++;
            try {
                System.out.println("Для регистрации на сайте заполните следующие поля:");
                System.out.println("Логин (длина от 5 до 20 символов, только латинские буквы и цифры):  ");
                String login = in.nextLine();
                System.out.println("Пароль (длина более 5, только латинские буквы и цифры и знак подчеркивания): ");
                String password = in.nextLine();
                System.out.println("Повторите пароль: ");
                String confirmPassword = in.nextLine();

                // проходим регистрацию на сайте
                user.signUp(login, password, confirmPassword);
                // регистрация успешна:
                user = new Auth(user.getLogin(), user.getPassword());

                // заходим на сайт
                for (int j=0;j<3;j++)
                {
                try {
                    System.out.println("Заходим на сайт:");
                    System.out.println("Введите логин:  ");
                    String login1 = in.nextLine();
                    System.out.println("Введите пароль: ");
                    String password1 = in.nextLine();

                    //заходим на сайт
                    user.signIn(login1, password1);
                    return;
                } catch (WrongPasswordException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }}
            // ловим ошибки регистрации
            catch (WrongLoginException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        while ((i<=3) && user.getLogin().isEmpty()) ;
            }}



