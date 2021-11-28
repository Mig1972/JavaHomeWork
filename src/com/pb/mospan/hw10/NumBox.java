package com.pb.mospan.hw10;

import com.pb.mospan.hw8.WrongPasswordException;

import static oracle.jrockit.jfr.events.Bits.doubleValue;

public class NumBox <T extends Number>  {

    private final T[] number;
    private int size_number;

    public NumBox (int size) {number = (T[]) new Number[size];}
    public void set (int index, T num) {this.number[index]=num;size_number++;}
    public void add (T num) {
        if (size_number<number.length)
        {this.number[size_number]=num;size_number++;}
        else {
            throw new ArrayIndexOutOfBoundsException ("Массив переполнен");}
    }

    public T get(int index) {return number[index];}

    public int length() {return size_number;}

    public double sum() {
        double summ=0.0;
        if (size_number>0)
        {for (int i=0; i<size_number; i++)
             {summ += number[i].doubleValue();}}
        else {throw new ArrayIndexOutOfBoundsException ("Массив пустой!");}
        return summ;
    }

    public double average() {
        if (size_number>0)
        {return sum()/size_number;}
        else {throw new ArrayIndexOutOfBoundsException ("Массив пустой!");}
         }

    public T max(){
        T maxx = number[0];
          if (size_number>0)
          {for(int i = 0; i < number.length; i++){
                  if(number[i].doubleValue() > maxx.doubleValue())
                     {maxx = number[i];}}}
          else {throw new ArrayIndexOutOfBoundsException ("Массив пустой!");}
              return maxx;
          }
    }
