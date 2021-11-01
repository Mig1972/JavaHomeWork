package com.pb.mospan.hw5;

import com.sun.org.apache.xpath.internal.objects.XNull;

public class Reader {
    private String full_name;         // ФИО
    private int library_card_number;  // номер читательского билета
    private String faculty;           // факультет
    private String date_of_birth;     //дата рождения
    private String phone_number;      // телефон

    public void Reader (String full_name,int library_card_number,String faculty,String date_of_birth, String phone_number) {
        this.full_name = full_name;
        if (library_card_number > 0)
        {this.library_card_number = library_card_number;}
        this.faculty = faculty;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
    }

    public String getInfo () {
        return (  "ФИО: "           + full_name + "\n"
                + "Факультет: "     + faculty + "\n"
                + "Номер билета: "  + library_card_number + "\n"
                + "Дата рождения: " + date_of_birth + "\n"
                + "Номер телефона: " +phone_number);}


    public String getFull_name()        {return full_name;}
    public int getLibrary_card_number() {return library_card_number;}
    public String getFaculty()          {return faculty;}
    public String getDate_of_Birth()    {return date_of_birth;}
    public String getPhone_number()     {return phone_number;}

    public void takeBook (int kol){
        if (kol==0)
        {System.out.println (this.full_name + " не взял(a) ни одной книги");}
        else { if (kol == 1) {
               System.out.println(this.full_name + " взял(a) " + kol + " книгу.");}
                else { if (kol == 2 || kol == 3 || kol == 4) {
                       System.out.println(this.full_name + " взял(a) " + kol + " книги.");}
                        else {System.out.println(this.full_name + " взял(a) " + kol + " книг.");}
                     }
              } System.out.print("\n");}

    public void takeBook (String... titles){
        System.out.println(this.full_name + " взял(а) следующие книги: ");
        for (String title: titles){
             System.out.println(title);}
        System.out.print ("\n");
          }

    public void takeBook (Book... books){
        System.out.println(this.full_name + " взял(а) следующие книги:");
        for (Book b1: books){
            System.out.println(b1.getInfo1());}
        System.out.print("\n");}

    public void  returnBook (int kol){
        if (kol==0)
        {System.out.println (this.full_name + " не вернул(a) ни одной книги");}
        else { if (kol == 1) {
               System.out.println(this.full_name + " вернул(a) " + kol + " книгу.");}
               else { if (kol == 2 || kol == 3 || kol == 4) {
                      System.out.println(this.full_name + " вернул(a) " + kol + " книги.");}
                      else {System.out.println(this.full_name + " вернул(a) " + kol + " книг.");}
                    }
              } System.out.print("\n");}

    public void returnBook (String... titles){
            System.out.println(this.full_name + " вернул(а) следующие книги: ");
            for (String title : titles) {
                System.out.println(title);}
            System.out.print ("\n");}

    public void returnBook (Book... books){
        System.out.println(this.full_name + " вернул(а) следующие книги:");
        for (Book b1: books){
            System.out.println(b1.getInfo1());}
        System.out.print("\n");}
    }


