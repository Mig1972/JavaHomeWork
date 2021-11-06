package com.pb.mospan.hw6;

import java.util.Objects;

public class Cat extends Animal {
    public String okras;

    public String getOkras() {return okras;}
    public String getVid() {return vid;}

    public Cat (String okras, String food, String location)
    {this.vid = "Кошка"; this.okras=okras; this.food = food; this.location=location;}

    public void setOkras(String okras) {this.okras = okras;}

    @Override
    public void eat (){
        System.out.println(this.okras + " " + vid +  " ест");}

    @Override
    public void makeNoise (){
        System.out.println(this.okras + " " + vid +  " мурлычет");}


    @Override
    public String toString() {
        return ("[Кошка:\n" +
                " окрас: " + okras +
                ", питается: " + food +
                ", живет в: " + location + " ]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(okras, cat.okras)
            && Objects.equals(vid, cat.vid)
            && Objects.equals(food, cat.food)
            && Objects.equals(location, cat.location)    ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, okras, food, location);
    }
}
