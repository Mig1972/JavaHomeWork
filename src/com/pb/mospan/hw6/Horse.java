package com.pb.mospan.hw6;

import java.util.Objects;

public class Horse extends Animal {
    public String mast;

    public Horse (String mast, String food, String location)
    {this.vid = "Лошадь"; this.mast=mast; this.food = food; this.location=location;}

    public String getMast() {
        return mast;
    }

    public void setMast(String mast) {
        this.mast = mast;
    }

    @Override
    public void eat (){
        System.out.println("Лошадь " +mast + " масти ест");}

    @Override
    public void makeNoise (){
        System.out.println("Лошадь " +mast + " масти ржет");}

    @Override
    public String toString() {
        return ("[Лошадь:\n" +
                " масть: " + mast +
                ", питается: " + food +
                ", живет в: " + location + " ]");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(mast, horse.mast)
                && Objects.equals(vid, horse.vid)
                && Objects.equals(food, horse.food)
                && Objects.equals(location, horse.location)    ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, mast, food, location);}

}
