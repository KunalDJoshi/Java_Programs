/**
* This is the Airplane class. Inherit Vehicle class and create accessors and mutators regarding user's airplane order
* Date: October 8, 2019
* @ author: Anjali Shiyamsaran
* @ version: 1.0
*/

public class Airplane extends Vehicle {
   final String [] WINGSHAPE = {"Wide","Narrow"};
   final String [] WEIGHT = {"Light","Heavy"};
   private int wingChoice;
   private int weightChoice;
    static final String PROMPT1 = "What shape are the wings?";
	 static final String PROMPT2 = "What is the weight of the plane?";

/**
* Add constructor, call class methods
*/   
   public Airplane() { //constructor with parameters
         this.wingChoice = showMenu(PROMPT1,WINGSHAPE);
		  this.weightChoice = showMenu(PROMPT2, WEIGHT);
 

   }
   
/**
* Call showMenu() method in Vehicle class regarding airplane wing shape   
*/      
   public void wingShape() {

      int returnValue = super.showMenu(PROMPT1, WINGSHAPE);
      this.setWings(returnValue);
   }
   
   public void setWings( int _wingChoice )     
   { 
      wingChoice = _wingChoice;    
   }

   public String getWings( )   { return WINGSHAPE[wingChoice]; }
   
/**
* Call showMenu() method in Vehicle class regarding plane weight   
*/      
      public void planeWeight() {

         int returnValue = super.showMenu(PROMPT2, WEIGHT);
         this.setWeight(returnValue);
   }
   
   public void setWeight( int _weightChoice )     
   { 
      weightChoice = _weightChoice;    
   }

   public String getWeight()   { 
      return WEIGHT[weightChoice]; 
   }
   
/**
* calculation of gas usage for airplane
*/   
   public double gasMileage() {
      double mileage = 0;

      if(this.getWeight().equals("Light")) {    
           mileage = 75.2;    
      } else if (this.getWeight().equals("Heavy")) {
           mileage = 43.8; 
      }
      return mileage;
   }  
       
/**
* return a String of all the airplane information formatted 
*/
    public String toString() { 
        return "Airplane: " + '\n' +
            " \t model: " + model + '\n' +
            " \t color: " + color + '\n' +
            " \t cost: $" + cost + '\n' +
            " \t MPG/GPH: " + gasMileage() + '\n' +
            "\t Wingshape: " + WINGSHAPE[wingChoice] + '\n' +
            "\t Weight: " + WEIGHT[weightChoice] + '\n';
    }      
} //end class Airplane