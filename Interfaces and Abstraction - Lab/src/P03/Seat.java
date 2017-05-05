package P03;

import java.io.Serializable;

public class Seat implements Sellable, Car, Serializable {
    private String model;
    private String color;
    private Double price;
    private String countryProduced;
    private int horsepower;

    public Seat(String model, String color, int horsepower, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.countryProduced = countryProduced;
        this.horsepower = horsepower;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.countryProduced, Car.TIRES);
    }
}
