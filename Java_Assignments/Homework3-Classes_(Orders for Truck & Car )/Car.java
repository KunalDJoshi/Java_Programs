/**
 *Car class has Car constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-09-24
 */
import java.util.*;
public class Car {
    private String model;
    private String color;
    private double cost;
    private int carType;
    private int carTowingPackage;
    private String carTypeArr[] = {
        "Sedan",
        "Coupe",
        "Wagon"
    };
    private String carTowingPackageArr[] = {
        "Yes",
        "No"
    };


    Scanner scan = new Scanner(System.in);
	
    /**
    This is constructor of Car class. 
    */
    public Car() {
        this.model =acceptModel();
        this.color=acceptColor();
        this.cost=acceptCost();
        this.checkcarType();
        this.checkCarTowingPackage();
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
    @return the current value of carType.
    */
    public String getcarType() {
        return carTypeArr[carType];
    }
    /**
    @return the current value of carTowingPackage.
    */
    public String getcarTowingPackage() {
        return carTowingPackageArr[carTowingPackage];
    }

    /**
     * Changes the model of this Car.
     *
     * @param model The new value.
     */
    public void setModel(String _model) {
        this.model = _model;
    }
    /**
     * Changes the color of this Car.
     *
     * @param color The new value.
     */

    public void setColor(String _color) {
        this.color = _color;
    }

    /**
     * Changes the cost of this Car.
     *
     * @param cost The new value.
     */
    public void setCost(double _cost) {
        this.cost = _cost;
    }

/**
	This method is for accepting car model
   @return model value
	*/
	public String acceptModel()
	{
	 System.out.println("Model: ");
	 String model = scan.next();
	 return model;
	}
	
	/**
	This method is for accepting car color
   @return color value
	*/
	public String acceptColor()
	{
	 System.out.println("Color: ");
	 String color= scan.next();
	 return color;
	 
	}
	
	/**
	This method is for accepting car cost
   @return cost value
	*/
	public double acceptCost()
	{
	 System.out.println("Cost: ");
	 double cost= scan.nextDouble();
	 return cost;
	}
	

    /**
    This is method of Car class is used to check car type. 
    */
    public void checkcarType() {
        do {
            System.out.println("What is the type of Car?");
            for (int i = 0; i < carTypeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + carTypeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                carType = scan.nextInt();
            }
            scan.nextLine();

        } while (carType < 1 || carType > carTypeArr.length);
        carType--;
    }
    /**
    This is method of Car class is used to check Towing package. 
    */

    public void checkCarTowingPackage() {
        do {
            System.out.println("Does car has towing package?");
            for (int i = 0; i < carTowingPackageArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + carTowingPackageArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                carTowingPackage = scan.nextInt();
            }
            scan.nextLine();

        } while (carTowingPackage < 1 || carTowingPackage > carTowingPackageArr.length);
        carTowingPackage--;


    }

    /** Return a string representation of this object */
    @Override
    public String toString() {
        return "Car: " + '\n' +
            " \t model: " + model + '\n' +
            " \t color: " + color + '\n' +
            " \t cost: $" + cost + '\n' +
            " \t Type: " + carTypeArr[carType] + '\n' +
            " \t Towing: " + carTowingPackageArr[carTowingPackage] + '\n';

    }
}