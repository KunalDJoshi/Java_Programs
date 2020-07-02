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

    /**
    This is constructor of Car class. 
    */
    public Car() {}


    /**
    @return the current value of Attribut Label.
    */
    public static String[] getAttributeLabels() {
        return ATTRIBUTE_LABELS;
    }

    /**
    @return the current value of carType.
    */
    public static String[] getCarTypes() {
        return CARTYPE_CHOICES;
    }
    /**
    @return the current value of carTowingPackage.
    */
    public static String[] getTowingPackage() {
        return TOWING_PACKAGE;
    }

}