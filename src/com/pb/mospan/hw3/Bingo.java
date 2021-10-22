package com.pb.mospan.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt (101) ;
        int counter=0;
        int newNumber;
        System.out.println (randomNumber);
        System.out.println ("Угадайте целое число, которое загадала программа");
        System.out.println ("Число находится в диапазоне от 0 до 100");
        System.out.println ("Для выхода из игры нажмите -1");
        System.out.println ("Начали!!!");
        do {
            counter++;
        System.out.println ("Введите целое число от 0 до 100: ");
        newNumber = in.nextInt();
            if(newNumber == -1) {
                System.out.println("Вы попытались угадать " + (counter-1) + " раз.");
                System.out.println("Но, к сожалению, так и не угадали число.");
                break;}
            else {
        if (newNumber==randomNumber) {System.out.println ("УРА!!! Вы угадали c " + counter + "-ой попытки");
            System.out.println("Игра завершена."); break;}
        else {
            if (newNumber<randomNumber) {System.out.println ("Вы не угадали... Попробуйте ввести большее число");}
                else {
                     if (newNumber>randomNumber) {System.out.println ("Вы не угадали... Попробуйте ввести меньшее число");}
                }
            }}}
        while (newNumber!=-1);

}}
