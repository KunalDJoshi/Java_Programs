public class TipCalculation {
    static double bill;
    static int tip;
    static double tipAmount;
    public static void main(String[] args) {
        // verify that two arguments were entered on the command line.  
        if (args.length != 2) {
            System.out.println("You need to enter two args.");
            System.exit(1);
        }

        // assuming the two string values entered are really numbers,
        // try to convert them to doubles and integer.
        try {
            //bill = Double.parseDouble(args[0]);//This is one way to convert String to double
            //tip= Integre.parseInteger(args[1]);//This is one way to convert String to integer

            //creating Double object reference 
            Double doubleobj = new Double(args[0]);
            //Converting the wrapper object to primitive
            bill = doubleobj.doubleValue();
            System.out.println("Bill entered is :$" + bill);

            //creating Integer object reference
            Integer intobj = new Integer(args[1]);
            //Converting the wrapper object to primitive
            tip = intobj.intValue();
            System.out.println("Tip entered is: " + tip + "%");



        } // Non numbers entered, catch the error and gracefully exit.
        catch (NumberFormatException nfe) {
            System.out.println(nfe);
            System.out.println("Arguments passed are wrong.");
            System.exit(2);
        }
        //Tip amount calculation	  
        tipAmount = bill * tip / 100;
        System.out.println("Tip amount is :$" + tipAmount);

    }
}