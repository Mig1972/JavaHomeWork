package com.pb.mospan.hw5;

public class Library {
    public static void main(String[] args) {

    Book [] books = new Book[5];
    Reader [] readers = new Reader[3];

    for (int i=0; i< books.length; i++)
    {books[i]= new Book();}

    for (int i=0; i< readers.length; i++)
    {readers[i]= new Reader();}

    books[0].setAll("Боли в плече, или как вернуть подвижность рукам","Сергей Бубновский","2016");
    books[1].setAll("Сценарии жизни или мистические врата судьбы","Владимир Захаров","2021");
    books[2].setAll("Мануальная терапия миофасциальных болевых синдромов","А.А.Алиев","1993");
    books[3].setAll("Боль в спине и шее","П.В.Евдокименко","2014");
    books[4].setAll("Основы фэн-шуй","Лилиан ТУ","2007");

    readers[0].Reader("Мосьпан И.Г.", -1, "Прикладная математика","27-10-1972","+380681234567");
    readers[1].Reader("Кацалап В.Л.", 54321, "Прикладная динамика", "30-05-1973", "+380981234567");
    readers[2].Reader("Дорофеева М.В.", 12354, "Механико-математический", "17-09-1972", "+4201234567");

        for (int i=0; i<3; i++) {
        System.out.println("[Книга" + (i+1) + ": \n"
                         +  books[i].getInfo() + "]\n");}

        for (int i=0; i<3; i++) {
        System.out.println("[Читатель" + (i+1) + ": \n"
                         +  readers[i].getInfo() + "]\n");}

        readers[0].takeBook(2);
        readers[0].takeBook (books[0].getTitle(), books[1].getTitle());
        readers[0].takeBook (books[0], books[1]);
        readers[0].returnBook(1);
        readers[0].returnBook (books[1].getTitle());
        readers[0].returnBook (books[1]);

        readers[1].takeBook(3);
        readers[1].takeBook (books[2].getTitle(), books[3].getTitle(), books[4].getTitle());
        readers[1].takeBook (books[2], books[3], books[4]);
        readers[1].returnBook(2);
        readers[1].returnBook (books[3].getTitle(),books[4].getTitle());
        readers[1].returnBook (books[3], books[4]);

        readers[2].takeBook(1);
        readers[2].takeBook (books[0].getTitle());
        readers[2].takeBook (books[0]);
        readers[2].returnBook(1);
        readers[2].returnBook (books[4].getTitle());
        readers[2].returnBook (books[4]);
    }
}
