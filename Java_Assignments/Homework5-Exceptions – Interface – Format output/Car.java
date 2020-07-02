/**
 *Car class extends Vehicle class.
 *Car class has Car constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-09-24
 */

public class Car extends Vehicle{

    private int carType;
    private int carTowingPackage;
    public static final String carTypeArr[] = {
        "Sedan",
        "Coupe",
        "Wagon"
    };
	 static final String PROMPT1 = "What is the type of Car?";
	 static final String PROMPT2 = "Does car has towing package?";
    protected String carTowingPackageArr[] = {
        "Yes",
        "No"
    };
    static final double mileage1=23.7;
    static final double mileage2=28.2;
    static final double mileage3=19.5;
    static final double TowingConst=3; 
	
    /**
    This is constructor of Car class. 
    */
    public Car() {

        this.carType = showMenu(PROMPT1,carTypeArr);
		  this.carTowingPackage = showMenu(PROMPT2, carTowingPackageArr);
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
    
    
     /**
    This is method of Vinfo interface is implemented here. It returns mileage of Car.
    @return mileage
    */
   public double gasMileage()
   {
    double mileage=0;
    if(getcarType().equals("Sedan")&& getcarTowingPackage().equals("Yes"))
    {
      mileage= mileage1-TowingConst;
    }
    else if(getcarType().equals("Sedan")&& getcarTowingPackage().equals("No"))
    {
     mileage= mileage1;
    }
    if(getcarType().equals("Coupe")&& getcarTowingPackage().equals("Yes"))
    {
     mileage= mileage2-TowingConst;
    }
    else if(getcarType().equals("Coupe")&& getcarTowingPackage().equals("No"))
    {
     mileage= mileage2;
    }
    if(getcarType().equals("Wagon")&& getcarTowingPackage().equals("Yes"))
    {
     mileage= mileage3-TowingConst;
    }
     else if(getcarType().equals("Wagon")&& getcarTowingPackage().equals("No"))
    {
     mileage= mileage3;
    }

    return mileage;
   }



    /** Return a string representation of this object */
    @Override
    public String toString() {
    return "Car: " + '\n' +
            " \t model: " + model + '\n' +
            " \t color: " + color + '\n' +
            " \t cost: $" + cost + '\n' +
            " \t MPG/GPH: " + gasMileage() + '\n' +
            " \t Type: " + carTypeArr[carType] + '\n' +
            " \t Towing: " + carTowingPackageArr[carTowingPackage] + '\n';

    }
}