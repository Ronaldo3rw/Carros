package br.com.tresrw.carros.entities;

/**
 * Created by Roni on 26/02/2018.
 */

public class Car {

    public int id;
    public String model;
    public int horsePower;
    public Double price;

    public Car(int id, String model, int horsePower, Double price){
        this.id = id;
        this.model = model;
        this.horsePower = horsePower;
        this.price = price;
    }
}
