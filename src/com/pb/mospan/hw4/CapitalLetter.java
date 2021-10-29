package com.pb.mospan.hw4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CapitalLetter {

    static String Chage (String Stroka1) {
        String Stroka2="";
        //первый символ делаю заглавным
        Stroka2 = Stroka2 + Stroka1.substring(0, 1).toUpperCase();
        Stroka2 = Stroka2 + Stroka1.substring(1,Stroka1.length());
       // System.out.println (Stroka2);
        return Stroka2;}

    public static void main(String[] args) {
//Программа, которая принимает строку и переводит
// первую букву слова в верхний регистр.
        Scanner in = new Scanner(System.in);
        String beginStroka;
        String finishStroka ="";
        String S="";
        System.out.println("Введите строку:");
        beginStroka = in.nextLine();
        beginStroka = beginStroka.trim(); //убираю лишние пробелы в начале и конце

        StringTokenizer st = new StringTokenizer(beginStroka);

        while (st.hasMoreElements()) {
            S=""+(st.nextElement());
            finishStroka= finishStroka + Chage(S) + " ";
        }
        System.out.println(finishStroka);
    }
}
