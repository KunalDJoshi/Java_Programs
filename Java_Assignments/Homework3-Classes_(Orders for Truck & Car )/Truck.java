/**
 *Truck class has Truck constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-09-24
 */
import java.util.*;
public class Truck {
    private String model;
    private String color;
    private double cost;
    private int truckSize;
    private int truckEngineSize;
    private String truckSizeArr[] = {
        "half ton",
        "One ton"
    };
    private String engineSizeArr[] = {
        "Really big",
        "Not so big"
    };


    Scanner scan = new Scanner(System.in);
	

    /**
    This is constructor of Truck class. 
    */
    public Truck() {
        this.model =acceptModel();
        this.color=acceptColor();
        this.cost=acceptCost();
        this.checkTruckSize();
        this.checkEngineSize();
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
    @return the current value of trucksize.
    */

    public String getTruckSize() {
        return truckSizeArr[truckSize];
    }
    /**
    @return the current value of truckEngineSize.
    */

    public String getTruckEngineSize() {
        return engineSizeArr[truckEngineSize];
    }
    /**
     * Changes the model of this Truck.
     *
     * @param model The new value.
     */
    public void setModel(String _model) {
        this.model = _model;
    }
    /**
     * Changes the color of this Truck.
     *
     * @param color The new value.
     */
    public void setColor(String _color) {
        this.color = _color;
    }
    /**
     * Changes the cost of this Truck.
     *
     * @param cost The new value.
     */
    public void setCost(double _cost) {
        this.cost = _cost;
    }
	
	/**
	This method is for accepting truck model
   @return model value
	*/
	public String acceptModel()
	{
	 System.out.println("Model: ");
	 String model = scan.next();
	 return model;
	}
	
	/**
	This method is for accepting truck color
   @return color value
	*/
	public String acceptColor()
	{
	 System.out.println("Color: ");
	 String color= scan.next();
	 return color;
	 
	}
	
	/**
	This method is for accepting truck cost
   @return cost value
	*/
	public double acceptCost()
	{
	 System.out.println("Cost: ");
	 double cost= scan.nextDouble();
	 return cost;
	}
	
	
	
    /**
    This is method of Truck class is used to check truck size. 
    */
    public void checkTruckSize() {
        do {
            System.out.println("What is the size of truck?");
            for (int i = 0; i < truckSizeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + truckSizeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                truckSize = scan.nextInt();
            }
            scan.nextLine();

        } while (truckSize < 1 || truckSize > truckSizeArr.length);
        truckSize--;
    }

    /**
    This is method of Truck class is used to check Engine size of truck. 
    */
    public void checkEngineSize() {
        do {
            System.out.println("What is the size of engine of the truck?");
            for (int i = 0; i < engineSizeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + engineSizeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                truckEngineSize = scan.nextInt();
            }
            scan.nextLine();

        } while (truckEngineSize < 1 || truckEngineSize > engineSizeArr.length);
        truckEngineSize--;


    }

    /** Return a string representation of this object */
    @Override
    public String toString() {

        return "Truck:" + '\n' +
            "\t Model: " + model + '\n' +
            "\t Color: " + color + '\n' +
            "\t Cost: $" + cost + '\n' +
            "\t Load: " + truckSizeArr[truckSize] + '\n' +
            "\t Engine: " + engineSizeArr[truckEngineSize] + '\n';
    }
}