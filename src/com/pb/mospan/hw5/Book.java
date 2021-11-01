package com.pb.mospan.hw5;

public class Book {
    private String title;        //название
    private String author;       //автор книги
    private String year_publish; //год издания


    public void setAll (String title, String author, String year_publish) {
        this.title = title;
        this.author = author;
        this.year_publish = year_publish;}

    public String getInfo () {
        return ("Название: "          + title + "\n"
                + "Автор: "           + author + "\n"
                + "Дата публикации: " + year_publish);}

    public String getInfo1 ()
           {return (title + ", (" + author + ", " + year_publish+ ")");}

    public String getTitle ()        {return title;}
    public String getAuthor ()       {return author;}
    public String getYear_publish () {return year_publish;}

    }


