package com.pb.mospan.hw7;

import com.pb.mospan.hw6.Animal;
import com.pb.mospan.hw6.Veterinarian;

public class Atelier {
    public static void dressMan(Clothes[] clothes)
    {   System.out.println("Мужская одежда:");
        for (Clothes c:clothes){
            if (c instanceof ManClothes) ((ManClothes) c).dressMan();}
    }
    public static void dressWomen(Clothes[] clothes)
    {   System.out.println("Женская одежда:");
        for (Clothes c:clothes){
            if (c instanceof WomenClothes) ((WomenClothes ) c).dressWomen();}
    }


    public static void main(String[] args) throws Exception {
        Tie tie1= new Tie (Size.M,450,"Синий");
        Pants pants1= new Pants (Size.XS,300,"Черный");
        Skirt skirt1= new Skirt (Size.XXS,1000,"Красный");
        Tshirt tshirt1= new Tshirt (Size.L,450,"Белый");

        Clothes[] clothes = new Clothes [] {tie1,pants1,skirt1,tshirt1};
        dressMan(clothes);
        dressWomen(clothes);
        }
}
