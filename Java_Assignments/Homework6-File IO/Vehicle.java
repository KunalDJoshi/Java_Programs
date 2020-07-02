/**
 *Vehicle class is parent class of Truck, Boat and Car classes.
 *Vehicle class has Vehicle constructor, accessors and mutators for private fields. 
 *Through toString method all field values are returned to main method in Order class.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-09-30
 */
import java.util.*;
import java.text.DecimalFormat;

public class Vehicle implements Vinfo {
 protected String model;
 protected String color;
 protected double cost;
 protected String vis;
 DecimalFormat df = new DecimalFormat("###.##");
 /**
    This is constructor of Vehicle class. 
    */

 public Vehicle() {
  this.model = acceptModel();
  this.color = acceptColor();
  this.cost = acceptCost();

 }

 Scanner scan = new Scanner(System.in);

 /**
    This is method of Vehicle class is used to check Vehicle type. 
    @return vis.
    */

 public String getVehIs() {

  switch (getClass().getSimpleName()) {
   case "Car":
    vis = Car.getVehicleIs();
    break;
   case "Boat":
    vis = Boat.getVehicleIs();
    break;
   case "Truck":
    vis = Truck.getVehicleIs();
    break;
   case "Airplane":
    vis = Airplane.getVehicleIs();
    break;
   case "Drone":
    vis = Drone.getVehicleIs();
    break;
   case "Scooter":
    vis = Scooter.getVehicleIs();
    break;

  }
  return vis;

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



 /**
	This method is for accepting Vehicle model
   @return model value
	*/
 public String acceptModel() {
  System.out.println("Model: ");
  String model = scan.next();
  return model;
 }

 /**
	This method is for accepting Vehicle color
   @return color value
	*/
 public String acceptColor() {
  System.out.println("Color: ");
  String color = scan.next();
  return color;

 }

 /**
 	This method is for accepting Vehicle cost
    @return cost value
 	*/
 public double acceptCost() {
  while (true) {
   System.out.println("Cost: ");

   if (!(scan.hasNextDouble())) {
    System.out.println("Invalid dollar amount, do not use $ or , in the entered cost. Try again.");
    scan.nextLine();
   } else {
    return scan.nextDouble();
   }
  }
 }
 /**
 This method accepts prompt and choices array as input parameters 
 and returns the choice.
 @param prompt
 @param choices[]
 @return choice
 */
 public int showMenu(String prompt, String[] choices) {
  int choice = 0;

  do {
   System.out.println(prompt);
   for (int i = 0; i < choices.length; i++) {
    System.out.println("\t" + (i + 1) + ". " + choices[i]);
   }
   try {
    System.out.print("\tChoice: ");



    if (scan.hasNextInt()) {
     choice = scan.nextInt();
    }
   } catch (Exception e) {
    System.out.println("No matching element found");
   }

   scan.nextLine();

  } while (choice < 1 || choice > choices.length);
  choice--;
  return choice;
 }

 /**
  * Overrides Interface class's toString() method
  *
  * @return a double value.
  */
 @Override
 public double gasMileage() {
  return 0;
 }

 /** Return a string representation of this object */
 @Override
 public String toString() {
  return getVehIs() + ":" + '\n' +
   " \t model: " + model + '\n' +
   " \t color: " + color + '\n' +
   " \t cost: $" + String.format("%,.2f", getCost()) + '\n' +
   " \t MPG/GPH: " + String.format("%,.1f", gasMileage()) + '\n';

 }



}