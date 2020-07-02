/**
 *Truck class.
 *Truck class has Truck constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-10-29
 */

import java.util.*;

public class Truck {

    private final static String[] TRUCKSIZE_CHOICES = {
        "Select Size .. ",
        "Half-ton",
        "Full ton"
    };

    private final static String[] ATTRIBUTE_LABELS = {
        "Truck size",
        "Engine size"
    };
    private final static String[] ENGINE_SIZE = {
        "Select Size .. ",
        "Really big",
        "Not so big"
    };

    final static String VEHICLE_IS = "Truck";
    protected String model;
    protected String color;
    protected double cost;
    protected String truckSize;
    protected String truckEngineSize;

    /**
    This is constructor of Truck class. 
    */
    public Truck(String _model, String _color, double _cost, String _truckSize, String _truckEngineSize) {
        this.model = _model;
        this.color = _color;
        this.cost = _cost;
        this.truckSize = _truckSize;
        this.truckEngineSize = _truckEngineSize;
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
    @return the current value of trucksize.
    */

    public String getTrucksizeChoices() {
        return truckSize;
    }

    /**
    @return the current value of truckEngineSize.
    */
    public String getTruckEngineSize() {
        return truckEngineSize;
    }


    /**
    @return the array of trucksize.
    */

    public static String[] getTrucksizeChoicesarr() {
        return TRUCKSIZE_CHOICES;
    }

    /**
    @return the array of truckEngineSize.
    */
    public static String[] getEngineSizearr() {
        return ENGINE_SIZE;
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
            "\t Load: " + getTrucksizeChoices() + '\n' +
            "\t Engine: " + getTruckEngineSize() + '\n';

    }

}