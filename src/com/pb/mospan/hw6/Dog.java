package com.pb.mospan.hw6;

import java.util.Objects;

public class Dog extends Animal {
    public String poroda;

    public Dog (String poroda, String food, String location)
    {this.vid = "Собака"; this.poroda=poroda; this.food = food; this.location=location;}

    @Override
    public void eat (){
        System.out.println("Собака породы " + poroda +  " ест");}

    @Override
    public void makeNoise (){
        System.out.println("Собака породы " + poroda +  " лает");}

    @Override
    public String toString() {
        return ("[Собака:\n" +
                " порода: " + poroda +
                ", питается: " + food +
                ", живет в: " + location + " ]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(poroda, dog.poroda)
                && Objects.equals(vid, dog.vid)
                && Objects.equals(food, dog.food)
                && Objects.equals(location, dog.location)    ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, poroda, food, location);}

}
