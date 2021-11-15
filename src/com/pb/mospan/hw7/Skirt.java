package com.pb.mospan.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private String vid;

    Skirt (Size size, int price, String colour) {
        super (size,price,colour);
        vid = "юбка";
    }

    public void dressWomen  () {
        System.out.println("Женская " + vid + ": размер- " + size +
                " (описание: " + size.getDescription() +
                ", европейский размер- " + size.getEuroSize() +
                "), цена=" + price + ", цвет- " + сolour); }
}


