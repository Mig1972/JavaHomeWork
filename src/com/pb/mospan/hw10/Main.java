package com.pb.mospan.hw10;

public class Main  {
    public static void main(String[] args) throws Exception {
        NumBox <Float> Float_P = new NumBox<>(5);
        NumBox <Integer> Integer_P = new NumBox<>(4);
        try {
            Integer_P.add(new Integer(0));
            Integer_P.set(1,new Integer(45646));
            Integer_P.add(new Integer(-555));
            Integer_P.set(3, new Integer(651));
            Integer_P.add(new Integer(-5821));
        } catch (Exception e) {
            System.out.println("Ошибка в массиве чисел Integer: "+ e.getMessage());}
  /*      try {
            Float_P.add(new Float(0.1231F));
            Float_P.set(1, new Float(101.0F));
            Float_P.add(new Float(-32145.45F));
            Float_P.set(3, new Float(5588.55F));
            Float_P.add(new Float(-1230.45F));
             } catch (Exception e) {
            System.out.println("Ошибка в массиве чисел Float: "+ e.getMessage());}
*/
        System.out.println("Сейчас в массиве чисел Integer заполнено " + Integer_P.length() + " чисел");
        System.out.println("Сейчас в массиве чисел Float заполнено " + Float_P.length() + " чисел");
        System.out.println("Печатаем массив чисел Integer");
        for (int i=0; i<Integer_P.length(); i++)
        {System.out.println("Число " + (i+1) + ": "+ Integer_P.get(i));}

        System.out.println("Печатаем массив чисел Float");
        for (int i=0; i<Float_P.length(); i++)
        {System.out.println("Число " + (i+1) + ": "+ Float_P.get(i));}

        System.out.println("Вычисляем суммы всех чисел в массивe Integer:");
        try {
            System.out.println("Сумма всех чисел массива Integer = " + Integer_P.sum());
            } catch (Exception e) {
            System.out.println(e.getMessage());}

        System.out.println("Вычисляем суммы всех чисел в массивe Float:");
        try {
           System.out.println("Сумма всех чисел массива Float = " + Float_P.sum());
        } catch (Exception e) {
            System.out.println(e.getMessage());}

        System.out.println("Вычисляем среднее арифметическое всех чисел в массивe Integer:");
        try {
            System.out.println("Среднее арифметическое всех чисел массива Integer = "+ Integer_P.average());
             } catch (Exception e) {
            System.out.println(e.getMessage());}

        System.out.println("Вычисляем Среднее арифметическое всех чисел в массивe Float:");
        try {
            System.out.println("Среднее арифметическое всех чисел массива Float = "+ Float_P.average());;
        } catch (Exception e) {
            System.out.println(e.getMessage());}

        System.out.println("Вычисляем максимальное число в массивe Integer:");
        try {
            System.out.println("Максимальное число массива Integer = "+ Integer_P.max());
        } catch (Exception e) {
            System.out.println(e.getMessage());}

        System.out.println("Вычисляем максимальное число в массивe Float:");
        try {
            System.out.println("Максимальное число массива Integer = "+ Float_P.max());
        } catch (Exception e) {
            System.out.println(e.getMessage());}
    }
}
