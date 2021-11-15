package com.pb.mospan.hw7;

public class Tie extends Clothes implements ManClothes {
    private String vid;

    Tie(Size size, int price, String colour) {
        super(size, price, colour);
        vid = "галстук";
    }

    public String getVid() {
           return vid;
    }

    public void dressMan() {
        System.out.println("Мужской " + vid + ": размер- " + size +
                " (описание: " + size.getDescription() +
                ", европейский размер- " + size.getEuroSize() +
                "), цена=" + price + ", цвет- " + сolour);
    }
}
