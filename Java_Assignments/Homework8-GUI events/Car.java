/**
 *Car class.
 *Car class has Car constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-10-29
 */
import java.util.*;


public class Car {
    private final static String[] CARTYPE_CHOICES = {
        "Select Type .. ",
        "Sedan",
        "Coupe",
        "Wagon"
    };

    private final static String[] ATTRIBUTE_LABELS = {
        "Car type",
        "Towing"
    };

    private final static String[] TOWING_PACKAGE = {
        "Select Towing .. ",
        "Included",
        "Not Included"
    };

    final static String VEHICLE_IS = "Car";
    protected String model;
    protected String color;
    protected double cost;
    protected String carType;
    protected String carTowingPackage;


    /**
    This is constructor of Car class. 
    */
    public Car(String _model, String _color, double _cost, String _carType, String _carTowingPackage) {
        this.model = _model;
        this.color = _color;
        this.cost = _cost;
        this.carType = _carType;
        this.carTowingPackage = _carTowingPackage;
    }


    /**
    @return the current value of vehicle.
    */
    public static String getVehicleIs() {
        return VEHICLE_IS;
    }


    /**
    @return the current value of Attribut Label.
    */
    public static String[] getAttributeLabels() {
        return ATTRIBUTE_LABELS;
    }

    /**
    @return the current value of carType.
    */
    public String getCarType() {
        return carType;
    }
    /**
    @return the current value of carTowingPackage.
    */
    public String getcarTowingPackage() {
        return carTowingPackage;
    }



    /**
    @return the array of carTowingPackage.
    */
    public static String[] getTowingPackagearr() {
        return TOWING_PACKAGE;
    }


    /**
    @return the array of carType.
    */
    public static String[] getCarTypesarr() {
        return CARTYPE_CHOICES;
    }

    /**
    @return the current value of model.
    */
    public String getModel() {
        return model;
    }
    /**
    @return the current value of color.
    */
    public String getColor() {
        return color;
    }
    /**
    @return the current value of cost.
    */
    public double getCost() {
        return cost;
    }


    /**
     * Changes the model of this Vehicle.
     *
     * @param model The new value.
     */
    public void setModel(String _model) {
        this.model = _model;
    }
    /**
     * Changes the color of this Vehicle.
     *
     * @param color The new value.
     */
    public void setColor(String _color) {
        this.color = _color;
    }
    /**
     * Changes the cost of this Vehicle.
     *
     * @param cost The new value.
     */
    public void setCost(double _cost) {
        this.cost = _cost;
    }


    /** Return a string representation of this object */
    @Override
    public String toString() {
        return VEHICLE_IS + ":" + '\n' +
            " \t model: " + model + '\n' +
            " \t color: " + color + '\n' +
            " \t cost: $" + String.format("%,.2f", getCost()) + '\n' +
            "\t Type: " + getCarType() + '\n' +
            "\t Towing: " + getcarTowingPackage() + '\n';

    }

}