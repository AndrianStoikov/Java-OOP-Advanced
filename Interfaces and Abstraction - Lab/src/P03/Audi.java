package P03;

import java.io.Serializable;

public class Audi implements Rentable, Car, Serializable{
    private String model;
    private String color;
    private String countryProduced;
    private int horsepower;
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsepower, String countryProduced, int minRentDay, Double pricePerDay) {
        this.model = model;
        this.color = color;
        this.countryProduced = countryProduced;
        this.horsepower = horsepower;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
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
