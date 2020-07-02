/**
 *Scooter class extends Vehicle class.
 *Scooter class has Scooter constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-10-06
 */
public class Scooter extends Vehicle {

    private int scooterType;
    private int scooterFuel;
    private String scooterTypeArr[] = {
        "IWL TR Troll",
        "IWL Wiesel"
    };
    private String scooterFuelArr[] = {
        "Petrol",
        "Diesel"
    };
    static final String PROMPT1 = "What is the size of Scooter?";
    static final String PROMPT2 = "What is the size of engine of the Scooter?";
    static final double mileage1 = 30.47;
    static final double mileage2 = 70.85;
    final static String VEHICLE_IS = "Scooter";



    /**
    This is constructor of Scooter class. 
    */
    public Scooter() {

        this.scooterType = showMenu(PROMPT1, scooterTypeArr);
        this.scooterFuel = showMenu(PROMPT2, scooterFuelArr);
    }
    /**
    @return the current value of vehicle.
    */

    public static String getVehicleIs() {
        return VEHICLE_IS;
    }

    /**
    @return the current value of scooterType.
    */

    public String getscooterType() {
        return scooterTypeArr[scooterType];
    }
    /**
    @return the current value of scooterFuel.
    */

    public String getscooterFuel() {
        return scooterFuelArr[scooterFuel];
    }

    /**
    This is method of Scooter class is used to check scooter type. 
    */
    public void checkscooterType() {
        do {
            System.out.println("What is the type of Scooter?");
            for (int i = 0; i < scooterTypeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + scooterTypeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                scooterType = scan.nextInt();
            }
            scan.nextLine();

        } while (scooterType < 1 || scooterType > scooterTypeArr.length);
        scooterType--;
    }
    /**
    This is method of Scooter class is used to check Fuel type. 
    */

    public void checkscooterFuel() {
        do {
            System.out.println("What is the size of engine of the Scooter?");
            for (int i = 0; i < scooterFuelArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + scooterFuelArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                scooterFuel = scan.nextInt();
            }
            scan.nextLine();

        } while (scooterFuel < 1 || scooterFuel > scooterFuelArr.length);
        scooterFuel--;


    }


    /**
    This is method of Vinfo interface is implemented here. It returns mileage of scooter.
    @return mileage
    */
    public double gasMileage() {
        double mileage = 0;
        if (getscooterType().equals("IWL TR Troll")) {
            mileage = mileage1;
        }
        if (getscooterType().equals("IWL Wiesel")) {
            mileage = mileage2;
        }
        return mileage;
    }



    /** Return a string representation of this object */
    @Override
    public String toString() {

        return super.toString() +
            "\t Load: " + scooterTypeArr[scooterType] + '\n' +
            "\t Engine: " + scooterFuelArr[scooterFuel] + '\n';

    }
}