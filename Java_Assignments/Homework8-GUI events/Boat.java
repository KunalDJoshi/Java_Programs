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


    final static String VEHICLE_IS = "Boat";
    protected String model;
    protected String color;
    protected double cost;
    protected String boatType;
    protected String boatConstruction;

    /**
    This is constructor of Boat class. 
    */
    public Boat(String _model, String _color, double _cost, String _boatType, String _boatConstruction) {
        this.model = _model;
        this.color = _color;
        this.cost = _cost;
        this.boatType = _boatType;
        this.boatConstruction = _boatConstruction;
    }

    /**
    @return the current value of vehicle.
    */
    public static String getVehicleIs() {
        return VEHICLE_IS;
    }

    /**
    @return the current value of boatType.
    */
    public String getBoatypeChoices() {
        return boatType;
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
    public String getboatConstruction() {
        return boatConstruction;
    }

    /**
    @return the array of vehicle.
    */
    public static String[] getBoatypeChoicesarr() {
        return VEHICLE_TYPE;
    }

    /**
    @return the array of boatConstruction.
    */
    public static String[] getBoatConstructionarr() {
        return BOAT_CONSTRUCTION;
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
            "\t Type: " + getBoatypeChoices() + '\n' +
            "\t Made of: " + getboatConstruction() + '\n';

    }

}