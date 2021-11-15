package com.pb.mospan.hw7;

public abstract class Clothes {
    protected Size size;
    protected int price;
    protected String сolour;

    public Clothes(Size size, int price, String сolour) {
        this.size=size;
        this.price=price;
        this.сolour=сolour;
    }

    public Size getSize() {return size;}
    public int getPrice() {return price;}
    public String getСolour() {return сolour;}

    public Clothes() {}

   }
