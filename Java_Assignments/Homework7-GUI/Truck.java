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

    /**
    This is constructor of Truck class. 
    */
    public Truck() {}
    /**
    @return the current value of Attribut Label.
    */
    public static String[] getAttributeLabels() {
        return ATTRIBUTE_LABELS;
    }

    /**
    @return the current value of trucksize.
    */

    public static String[] getTrucksizeChoices() {
        return TRUCKSIZE_CHOICES;
    }

    /**
    @return the current value of truckEngineSize.
    */
    public static String[] getEngineSize() {
        return ENGINE_SIZE;
    }

}