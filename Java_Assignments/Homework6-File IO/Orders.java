/**
<h1>Orders for Truck,Car and Boat</h1>
*The prgram implements an application that simply takes input from user as order 
*and dissplay user output on the screen.
*@author Kunal Joshi
*version 1.0
*@since 2019-09-24
*/
import java.util.*;
import java.io.*;
public class Orders {


    Collection < Character > specificChars = Arrays.asList('T', 't', 'C', 'c', 'B', 'b');
    Collection < Character > specificChars1 = Arrays.asList('Y', 'N');
    ArrayList < String > order = new ArrayList < > ();
    Scanner scan = new Scanner(System.in);
    String s3;
    String fileName = "VehicleOrders.dat";
    String file1 = "VehicleOrders.txt";
    ArrayList < Object > order1 = new ArrayList < > ();

    /**
    This is the main method which calls methods in Car,Truck,Boat,Scooter,Airplane,Drone classes. 
    * @param args Unused.
    * @return Nothing.
    * @exception IOException On input error.
    * @see IOException
    */

    public static void main(String args[]) throws IOException {
        System.out.println("Kunal Joshi's Ordering System (218-HW2)");


        Orders orders = new Orders();
        orders.loadOrder();
        orders.takeOrder();
        orders.saveOrder();
    }

    /**
	This method is for loading the vehicle order. It checks if  VehicleOrders.dat file exsists. If the file exists, 
   open the file and read the orders into the array list. 
   @return Nothing.
   * @exception IOException On input error.
   * @see IOException
	*/
    public void loadOrder() throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    order1.add(dis.readUTF());
                    order1.add(dis.readUTF());
                    order1.add(dis.readUTF());
                    order1.add(dis.readDouble());
                    order1.add(dis.readDouble());
                    order1.add(dis.readUTF());
                    order1.add(dis.readUTF());


                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        }
    }

    /**
	This method is for taking the vehicle order. Upon exit of the program, write the ordered data to a VehicleOrders.dat file that
   can be read in upon the next run of this program. It appends the new data at the end of previous data in VehicleOrders.dat file.
   @return Nothing.
   * @exception IOException On input error.
   * @see IOException
	*/
    public void takeOrder() throws IOException {
        do {
            System.out.println("Do you want to order a Truck (T/t), Car (C/c) or Boat (B/b) or Scooter (S/s) or Drone (D/d) or Airplane (A/a)?");
            char c = scan.next().charAt(0);

            //System.out.println("c = "+c); 
            if (!specificChars.contains(c)) {
                System.out.println("Invalid Input");
            } else
                System.out.println("You have entered: " + c);

            String s = Character.toString(c);

            DataOutputStream daOuSt = new DataOutputStream(new FileOutputStream(fileName, true));

            if (s.equals("T") || s.equals("t")) {
                Truck truck = new Truck();
                System.out.println(truck);
                order.add(truck.toString());

                daOuSt.writeUTF(truck.getVehIs());
                daOuSt.writeUTF(truck.getModel());
                daOuSt.writeUTF(truck.getColor());
                daOuSt.writeDouble(truck.getCost());
                daOuSt.writeDouble(truck.gasMileage());
                daOuSt.writeUTF(truck.getTruckSize());
                daOuSt.writeUTF(truck.getTruckEngineSize());

            }


            if (s.equals("C") || s.equals("c")) {
                Car car = new Car();


                System.out.println(car);
                order.add(car.toString());

                daOuSt.writeUTF(car.getVehIs());
                daOuSt.writeUTF(car.getModel());
                daOuSt.writeUTF(car.getColor());
                daOuSt.writeDouble(car.getCost());
                daOuSt.writeDouble(car.gasMileage());
                daOuSt.writeUTF(car.getcarType());
                daOuSt.writeUTF(car.getcarTowingPackage());
            }

            if (s.equals("B") || s.equals("b")) {
                Boat boat = new Boat();
                System.out.println(boat);
                order.add(boat.toString());

                daOuSt.writeUTF(boat.getVehIs());
                daOuSt.writeUTF(boat.getModel());
                daOuSt.writeUTF(boat.getColor());
                daOuSt.writeDouble(boat.getCost());
                daOuSt.writeDouble(boat.gasMileage());
                daOuSt.writeUTF(boat.getboatType());
                daOuSt.writeUTF(boat.getboatConstruction());
            }

            if (s.equals("S") || s.equals("s")) {
                Scooter scooter = new Scooter();
                System.out.println(scooter);
                order.add(scooter.toString());

                daOuSt.writeUTF(scooter.getVehIs());
                daOuSt.writeUTF(scooter.getModel());
                daOuSt.writeUTF(scooter.getColor());
                daOuSt.writeDouble(scooter.getCost());
                daOuSt.writeDouble(scooter.gasMileage());
                daOuSt.writeUTF(scooter.getscooterType());
                daOuSt.writeUTF(scooter.getscooterFuel());
            }

            if (s.equals("D") || s.equals("d")) {
                Drone drone = new Drone();
                System.out.println(drone);
                order.add(drone.toString());

                daOuSt.writeUTF(drone.getVehIs());
                daOuSt.writeUTF(drone.getModel());
                daOuSt.writeUTF(drone.getColor());
                daOuSt.writeDouble(drone.getCost());
                daOuSt.writeDouble(drone.gasMileage());
                daOuSt.writeUTF(drone.getvSize());
                daOuSt.writeUTF(drone.getpBlade());
            }

            if (s.equals("A") || s.equals("a")) {
                Airplane airplane = new Airplane();
                System.out.println(airplane);
                order.add(airplane.toString());

                daOuSt.writeUTF(airplane.getVehIs());
                daOuSt.writeUTF(airplane.getModel());
                daOuSt.writeUTF(airplane.getColor());
                daOuSt.writeDouble(airplane.getCost());
                daOuSt.writeDouble(airplane.gasMileage());
                daOuSt.writeUTF(airplane.getWings());
                daOuSt.writeUTF(airplane.getWeight());
            }
            daOuSt.flush();
            daOuSt.close();
            System.out.println("Do you want to order another vehicle?(Y/N)");
            char ch = scan.next().charAt(0);
            if (!specificChars1.contains(ch)) {
                System.out.println("Invalid Input");
            } else
                System.out.println("You have entered: " + ch);

            s3 = Character.toString(ch);
        }

        while (s3.equals("Y"));



        if (s3.equals("N")) {
            for (String orderList: order) {

                System.out.println(orderList);

            }

            System.out.println("Thank you for using Kunal Joshi's Ordering System.");
        }
    }

    /**
	This method is for saving the vehicle order in VehicleOrders.txt file. Upon exit of the program, write the ordered data to a VehicleOrders.txt file.
   It appends the new data at the end of previous data in VehicleOrders.txt file.
   @return Nothing.
   * @exception IOException On input error.
   * @see IOException
	*/

    public void saveOrder() throws IOException {


        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));

        for (String orderList: order) {

            pw.println(orderList);

        }

        pw.flush();
        pw.close();
    }


}