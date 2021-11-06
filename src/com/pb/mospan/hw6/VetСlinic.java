package com.pb.mospan.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Animal anim1 = new Animal("Мышь","Семечки","Норка");
        Cat cat1 = new Cat ("Рыжая", "Молоко", "Квартира");
        Cat cat2 = new Cat ("Черный", "Кошачий корм", "Дом в селе");
        Cat cat3 = new Cat ("Рыжая", "Молоко", "Квартира");
        Dog dog1 = new Dog ("Овчарка", "Кости", "Конура");
        Horse horse1 = new Horse ("Гнедой", "Яблоки", "Конюшня");
        Animal[] animals = new Animal[]{anim1, cat1, cat2, cat3, dog1, horse1};

        System.out.println("Печатаем массив всех объектов через переопределенный метод toString: \n" +
                "в методе Animal я не переопределяла метод toString, поэтому печатает зашифрованную строку");
        for (Animal a:animals)
            {System.out.println(a);}

        System.out.println("Проверяем работу всех методов:");
        for (Animal a:animals)
        {a.sleep();
         a.makeNoise();
         a.eat();}

        System.out.println("Проверяем работу переопределенных методов equals:");
        System.out.println("Сравниваю объекты Cat1 и Cat2: " + cat1.equals(cat2));
        System.out.println("Сравниваю объекты Cat1 и Cat3: " + cat1.equals(cat3));
        System.out.println("Сравниваю объекты Cat2 и Cat3: " + cat2.equals(cat3));
        System.out.println("Сравниваю объекты Cat1 и Cat1: " + cat1.equals(cat1));
        System.out.println("Сравниваю объекты Cat2 и Dog1: " + cat2.equals(dog1));
        System.out.println("Сравниваю объекты Horse1 и Horse1: " + horse1.equals(horse1));

        System.out.println("Проверяем работу переопределенных методов hashCode:");
        System.out.println("hashCode Cat1: " + cat1.hashCode());
        System.out.println("hashCode Cat2: " + cat2.hashCode());
        System.out.println("hashCode Dog1: " + dog1.hashCode());
        System.out.println("hashCode Horse1: " + horse1.hashCode());

       // Veterinarian vet = new Veterinarian();

        System.out.println("Создали класс Veterinarian методом рекурсии.\n" +
                           "Выводим сообщения при помощи метода treatAnimal из класса Veterinarian");
        Class vetClazz = Class.forName ("com.pb.mospan.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor();
        Object vet = constr.newInstance();
        if (vet instanceof Veterinarian) {
           for (Animal a : animals) {
               ((Veterinarian) vet).treatAnimal(a);
            }
        }
    }
}
