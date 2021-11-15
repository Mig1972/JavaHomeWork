package com.pb.mospan.hw7;

public class Tshirt extends Clothes implements ManClothes,WomenClothes {
    private String vid;

    Tshirt (Size size, int price, String colour) {
        super (size,price,colour);
        vid = "футболка";
    }

    public void dressMan () {
        System.out.println("Мужская "+ vid+": размер- " + size +
        " (описание : " + size.getDescription() +
        ", европейский размер- " + size.getEuroSize()+
        "), цена="+ price + ", цвет- "+ сolour);
    }

    public void dressWomen  () {
        System.out.println("Женская " + vid + ": размер- " + size +
                " (описание : " + size.getDescription() +
                ", европейский размер- " + size.getEuroSize() +
                "), цена=" + price + ", цвет- " + сolour);}

}
