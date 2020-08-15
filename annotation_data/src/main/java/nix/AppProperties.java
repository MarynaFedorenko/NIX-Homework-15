package nix;

import nix.annotation.PropertyKey;

public class AppProperties {

    @PropertyKey("brand")
    public String brand;

    @PropertyKey("model")
    public String model;

    @PropertyKey("car_body")
    public String car_body;

    @PropertyKey("year")
    public int year;

    @PropertyKey("gas_tank_capacity")
    public double gas_tank_capacity;

    @PropertyKey("price")
    public long price;

    @PropertyKey("four-wheel_drive")
    public boolean drive;


    public void print() {
        System.out.println( "CAR CHARACTERISTICS  \n"
                + "Brand:    " + brand + '\n'
                + "Model:    " + model + '\n'
                + "Car body: " + car_body + '\n'
                + "Year:     " + year + '\n'
                + "Gas tank: " + gas_tank_capacity + "L\n"
                + "Price:    " + price + "$\n"
                + "Four-wheel drive:   " + drive);
    }
}
