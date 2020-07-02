/**
 *Truck class extends Vehicle class.
 *Truck class has Truck constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-09-24
 */
 import java.lang.Math;
 public class Truck extends Vehicle{

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
    static final String PROMPT1 = "What is the size of truck?";
	 static final String PROMPT2 = "What is the size of engine of the truck?";

 
	

    /**
    This is constructor of Truck class. 
    */
    public Truck() {

        this.truckSize = showMenu(PROMPT1,truckSizeArr);
		  this.truckEngineSize = showMenu(PROMPT2, engineSizeArr);
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
    
      /**
    This is method of Vinfo interface is implemented here. It returns mileage of Truck.
    @return mileage
    */
    public double gasMileage()
    {
     double mileage=0;
     double TruckPrice = getCost();
     mileage=50-( Math.sqrt( TruckPrice )/10.0 );
     return mileage;
    }

    /** Return a string representation of this object */
    @Override
    public String toString() {

        return "Truck: " + '\n' +
            " \t model: " + model + '\n' +
            " \t color: " + color + '\n' +
            " \t cost: $" + cost + '\n' +
            " \t MPG/GPH: " + gasMileage() + '\n' +
            "\t Load: " + truckSizeArr[truckSize] + '\n' +
            "\t Engine: " + engineSizeArr[truckEngineSize] + '\n';
    }
}