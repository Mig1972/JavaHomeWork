package com.pb.mospan.hw6;

public class Veterinarian {

    public void treatAnimal(Animal animal){
        System.out.println("На приеме у ветеринара: " + animal.getVid() +
                           ", кушает " + animal.getFood() +
                           ", находится в " + animal.getLocation());
    }
}
