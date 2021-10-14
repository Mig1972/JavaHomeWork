package com.pb.mospan.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //int operand1;
        //int operand2;
        //String sign;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число1: ");
        int operand1 = in.nextInt();
        System.out.println("Введите целое число2: ");
        int operand2 = in.nextInt();
        System.out.println("Введите знак арифметической операции (+ - / : )");
        String sign = in.next();
        switch (sign) {
            case ("+"):
                System.out.println("Результат операции: " + operand1 + "+" + operand2 + "=" + (operand1 + operand2));
                break;
            case ("-"):
                System.out.println("Результат операции: " + operand1 + "-" + operand2 + "=" + (operand1 - operand2));
                break;
            case ("*"):
                System.out.println("Результат операции: " + operand1 + "*" + operand2 + "=" + (operand1 * operand2));
                break;
            case ("/"):
                if (operand2 == 0)
                {System.out.println("Ошибка: деление на 0");}
                else {
                    System.out.println("Результат операции: " + operand1 + "/" + operand2 + "=" + (operand1 / operand2));
                }
                break;
            default:
                {System.out.println("Ошибка: Неизвестный оператор");}

        }

    }}
