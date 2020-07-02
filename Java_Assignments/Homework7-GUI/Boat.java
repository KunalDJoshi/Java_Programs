/**
 * Boat class.
 *Boat class has Boat constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-10-29
 */
public class Boat {

    private final static String[] VEHICLE_TYPE = {
        "Select Type .. ",
        "Pontoon",
        "PWC",
        "Sailboat"
    };
    private final static String[] ATTRIBUTE_LABELS = {
        "Boat type",
        "Material"
    };
    private final static String[] BOAT_CONSTRUCTION = {
        "Select Construction .. ",
        "Wood",
        "Fiberglass",
        "Steel"
    };

    /**
    This is constructor of Boat class. 
    */
    public Boat() {}

    /**
    @return the current value of vehicle.
    */
    public static String[] getBoatypeChoices() {
        return VEHICLE_TYPE;
    }

    /**
    @return the current value of Attribut Label.
    */
    public static String[] getAttributeLabels() {
        return ATTRIBUTE_LABELS;
    }
    /**
    @return the current value of boatConstruction.
    */
    public static String[] getBoatConstruction() {
        return BOAT_CONSTRUCTION;
    }
}