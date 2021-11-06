package com.pb.mospan.hw6;

public class Animal {
    public String vid;
    public String food;
    public String location;

    public String getVid() {return vid;}
    public String getFood() {return food;}
    public String getLocation() {return location;}

    public Animal (String vid, String food, String location)
           {this.vid = vid; this.food = food; this.location = location;}

    public Animal(){};

    public void sleep (){
        System.out.println(this.vid +" спит");}

    public void eat (){
        System.out.println(this.vid +" ест"+ " " + food);}

    public void makeNoise (){
        System.out.println(this.vid + " шумит");}

   /* @Override
    public String toString() {
        return ("[" +  vid + ":\n" +
                " питается: " + food +
                ", живет в :" + location + " ]");}*/
}
