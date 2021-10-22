package com.pb.mospan.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        int Summa = 0;
        int positive = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Вам необходимо ввести 10 целых чисел");
        /*===Вводим массив===*/
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите " + (i + 1) + "-е число: ");
            array[i] = in.nextInt();
        }
        /*===Печатаем массив===*/
        System.out.print("\n Введенный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        /*===Считаем сумму всех чисел в массиве===*/
        for (int i = 0; i < array.length; i++) {
            Summa = Summa + array[i];
        }
        System.out.print("\n Сумма всех элементов массива: " + Summa);
        /*===Считаем количество положительных чисел в массиве===*/
        for (int i = 0; i < array.length; i++) {
            if (array[i]>0) {++positive;}
                    }
        System.out.println("\n Количество положительных чисел в массиве: " + positive);
        /*===Сортируем массив===*/
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = array.length - 1; j > i; j--){
                if(array[j] < array[j-1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.print("\n Отсортированный массив: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
