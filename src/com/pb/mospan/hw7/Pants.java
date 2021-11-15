package com.pb.mospan.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    private String vid;

    Pants (Size size, int price, String colour) {
        super (size,price,colour);
        vid = "брюки";
    }

    public void dressMan () {
        System.out.println("Мужские " + vid + ": размер- " + size +
                " (описание: " + size.getDescription() +
                ", европейский размер- " + size.getEuroSize() +
                "), цена= " + price + ", цвет- " + сolour);;
    }

    public void dressWomen  () {
        System.out.println("Женские " + vid + ": размер- " + size +
                " (описание : " + size.getDescription() +
                ", европейский размер- " + size.getEuroSize() +
                "), цена=" + price + ", цвет- " + сolour);}
}
