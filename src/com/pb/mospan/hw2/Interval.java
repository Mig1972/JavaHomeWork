package com.pb.mospan.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        //int Numer;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int Numer = in.nextInt();
        if (Numer>=0 && Numer<=14)
            {System.out.println("Введенное число попало в промежуток [0-14]");}
        else {
            if (Numer >= 15 && Numer <= 35)
                {System.out.println("Введенное число попало в промежуток [15-35]");}
                else {
                      if (Numer >= 36 && Numer <= 50)
                          {System.out.println("Введенное число попало в промежуток [36-50]");}
                      else {
                          if (Numer >= 50 && Numer <= 100) {
                              System.out.println("Введенное число попало в промежуток [50-100]");
                          } else {
                              System.out.println("Введенное число " + Numer + " не попало ни в один промежуток");
                          }
                      }}}}}