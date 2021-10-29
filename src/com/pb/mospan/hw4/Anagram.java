package com.pb.mospan.hw4;

import java.util.Scanner;
import java.util.Arrays;

public class Anagram {

    static String Metod1 (String Stroka) {
        //Убираю лишние символы
        String Stroka1 = Stroka.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", "");
        //Перевожу в нижний регистр
        Stroka1 = Stroka1.toLowerCase();
        return Stroka1;}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Данная программа определяет, является ли одна строка");
        System.out.println("анаграммой другой строки.");

        System.out.println("Введите первую строку:");
        String Stroka1 = in.nextLine();

        System.out.println("Введите вторую строку:");
        String Stroka2 = in.nextLine();
    //Убираю лишние символы и перевожу строки в нижний регистр
        String newStr1 = Metod1 (Stroka1);
        String newStr2 = Metod1 (Stroka2);

    //Сравниваю длину строк
        if (newStr1.length() != newStr2.length())
        {System.out.println ("Строка1 НЕ ЯВЛЯЕТСЯ анаграммой Строки2");}
        else {
    //Делаю массивы букв из строк
        char[] result1 = newStr1.toCharArray();
        char[] result2 = newStr2.toCharArray();
    //Сортирую массивы
            Arrays.sort(result1);
            Arrays.sort(result2);
        int i=0;
            while (i < result1.length) {
                if (result1[i]!=result2[i])
                {System.out.println ("Строка1 НЕ ЯВЛЯЕТСЯ анаграммой Строки2");
                   break;}
                else i++;
            }
            if (i==result1.length)
            {System.out.println ("Строка1 ЯВЛЯЕТСЯ анаграммой Строки2");}
                }
        }
}
