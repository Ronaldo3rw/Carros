package br.com.tresrw.carros.entities;

import android.graphics.drawable.Drawable;

/**
 * Created by Roni on 26/02/2018.
 */

public class Car {

    public int id;
    public String model;
    public String manufacturer;
    public int horsePower;
    public Double price;
    public Drawable picture;

    public Car(int id, String model, String manufacturer, int horsePower, Double price, Drawable picture) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
        this.price = price;
        this.picture = picture;
    }
}
