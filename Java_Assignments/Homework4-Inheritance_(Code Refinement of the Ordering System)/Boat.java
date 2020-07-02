/**
 * Boat class extends Vehicle class.
 *Boat class has Boat constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-09-30
 */
public class Boat extends Vehicle 
{

    private int boatType;
    private int boatConstruction;
	private String boatTypeArr[] = {
        "Pontoon",
        "PWC",
        "Sailboat"
    };
    private String boatConstructionArr[] = {
        "Wood",
        "Fiberglass",
		"Steel"
    };
    
   public static final String PROMPT1 = "What type of boat is this?";
	public static final String PROMPT2 = "What is the boat's construction?";
	
   
    /**
    This is constructor of Boat class. 
    */
	public Boat()
	{

        this.boatType = showMenu(PROMPT1,boatTypeArr);
		  this.boatConstruction = showMenu(PROMPT2, boatConstructionArr);
	}
	
    /**
    @return the current value of boatType.
    */
    public String getboatType() {
        return boatTypeArr[boatType];
    }
    /**
    @return the current value of boatConstruction.
    */
    public String getboatConstruction() {
        return boatConstructionArr[boatConstruction];
    }	
	
	    /**
    This is method of boat class is used to check boat type. 
    */
    public void checkBoatType() {
        do {
            System.out.println("What type of boat is this?");
            for (int i = 0; i < boatTypeArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + boatTypeArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                boatType = scan.nextInt();
            }
            scan.nextLine();

        } while (boatType < 1 || boatType > boatTypeArr.length);
        boatType--;
    }
    /**
    This is method of boat class is used to check boat construction. 
    */

    public void checkBoatConstruction() {
        do {
            System.out.println("What is the boat's construction?");
            for (int i = 0; i < boatConstructionArr.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + boatConstructionArr[i]);
            }
            System.out.print("\tChoice: ");
            if (scan.hasNextInt()) {
                boatConstruction = scan.nextInt();
            }
            scan.nextLine();

        } while (boatConstruction < 1 || boatConstruction > boatConstructionArr.length);
        boatConstruction--;


    }

    /** Return a string representation of this object */
    @Override
    public String toString() {
        return "Boat: " + '\n' +
            " \t model: " + model + '\n' +
            " \t color: " + color + '\n' +
            " \t cost: $" + cost + '\n' +
            " \t Type: " + boatTypeArr[boatType] + '\n' +
            " \t Made of: " + boatConstructionArr[boatConstruction] + '\n';

    }

}