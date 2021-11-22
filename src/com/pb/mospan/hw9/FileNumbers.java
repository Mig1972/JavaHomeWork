package com.pb.mospan.hw9;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    static void printFile (String fileName) throws Exception
    {  // печать из файла
        FileReader reader = new FileReader (fileName);
        Scanner scan = new Scanner(reader);
        int i=1;
        try {
             while (scan.hasNextLine()) {
             System.out.println("Строка" + i + " : " + scan.nextLine());
                    i++; }
             } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        reader.close();
            }

    static void createNumbersFile() throws Exception {
        Random random = new Random();
        FileWriter writer = new FileWriter("d:/numbers.txt");

        // записываем в текстовый файл массив 10х10 целых чисел
        try{
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                writer.write((random.nextInt(99)+1)+" ");
            }
            writer.write("\n");
       }
    } catch (Exception ex) {
        System.out.println("Error with file write: " + ex);
    }
        writer.close();
    }

    static void createOddNumbersFile  () throws Exception
    {
        FileWriter writer = new FileWriter ("d:/odd-numbers.txt");
        FileReader reader = new FileReader ("d:/numbers.txt");
        Scanner scan = new Scanner(reader);

        int numeric;
        String s;

        try {
            while (scan.hasNextLine()) {
                s=(scan.nextLine());
                Scanner scan2 = new Scanner(s);
                    {while (scan2.hasNext())
                           {numeric=Integer.parseInt(scan2.next());
                               if (numeric%2==0) {numeric=0;}
                            writer.write(numeric+" ");
                           }}
                writer.write("\n");
                }
        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        reader.close();
        writer.close();
        }


    public static void main (String[] args) throws Exception {

        createNumbersFile();
        System.out.println("Печатаем файл 'numbers.txt' с массивом случайных чисел от 1 до 99:");
        printFile("d:/numbers.txt");
        
        createOddNumbersFile();
        System.out.println("Печатаем новый файл, где все четные числа заменены на 0:");
        printFile("d:/odd-numbers.txt");
    }
}

