/**
 * The Drone class inherits some methods from the Vehicle class
 * and uses those methods to capture user's input.
 * Returns a String of the details captured from the user.
 *
 * @author Bawade Zaki
 * @version 1.0
 * @since 06-10-2019
 */
public class Drone extends Vehicle {

    private int vSize;
    private int pBlade;
    private final static String prompt1 = ("What is the size of the drone?");
    private final static String prompt2 = ("What is the propeller size of the drone?");
    private final static String[] vSizeArr = {
        "Mini",
        "Micro",
        "Nano"
    };
    private final static String[] pBladeArr = {
        "3-Blade",
        "4-Blade"
    };
    private final static String[] MPG = {
        "3.0",
        "2.0",
        "1.5"
    };
    final static String VEHICLE_IS = "Drone";




    /**
     * Sole Constructor (for invocation in main class to capture user input for Drone)
     */
    public Drone() {

        this.vSize = showMenu(prompt1, vSizeArr);
        this.pBlade = showMenu(prompt2, pBladeArr);
    }

    /**
    @return the current value of vehicle.
    */
    public static String getVehicleIs() {
        return VEHICLE_IS;
    }

    /**
    @return the current value of vSize.
    */

    public String getvSize() {
        return vSizeArr[vSize];
    }
    /**
    @return the current value of pBlade.
    */

    public String getpBlade() {
        return pBladeArr[pBlade];
    }

    /**
    This is method of Drone class is used to check Drone type. 
    */
    public void checkvSize() {
        do {
            System.out.println("What is the type of Drone?");
            for (int i = 0; i < vSizeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + vSizeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                vSize = scan.nextInt();
            }
            scan.nextLine();

        } while (vSize < 1 || vSize > vSizeArr.length);
        vSize--;
    }
    /**
    This is method of Drone class is used to check Fuel type. 
    */

    public void checkpBlade() {
        do {
            System.out.println("What is the size of engine of the Drone?");
            for (int i = 0; i < pBladeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + pBladeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                pBlade = scan.nextInt();
            }
            scan.nextLine();

        } while (pBlade < 1 || pBlade > pBladeArr.length);
        pBlade--;


    }


    /**
     * Overrides the method from the Vinfo interface class
     * Sets the Miles per hour based on the Drone's Size
     *
     * @return A double representing Mileage per hour of the drone
     */

    //we will assume that Drone requires fuel for flying. Mini - 3 , Micro - 2 , Nano - 1.5
    @Override
    public double gasMileage() {

        if (getvSize().equals("Mini")) {
            return Double.parseDouble(MPG[0]);
        } else if (getvSize().equals("Micro")) {
            return Double.parseDouble(MPG[1]);
        } else if (getvSize().equals("Nano")) {
            return Double.parseDouble(MPG[2]);
        } else {
            return 0;
        }

    }



    /** Return a string representation of this object */
    @Override
    public String toString() {

        return super.toString() +
            "\t Size: " + vSizeArr[vSize] + '\n' +
            "\t Blade: " + pBladeArr[pBlade] + '\n';

    }
}