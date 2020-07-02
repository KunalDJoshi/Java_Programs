/**
 *Rating class has Rating constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-02
 */
public class Rating {

   private String avgRating;
	private String totRating;
	private String date;


    /**
    This is constructor of Rating class. 
    */
    public Rating(String avgRating, String totRating, String date) {
        this.avgRating = avgRating;
        this.totRating = totRating;
        this.date = date;


    }

    /**
    @return the current value of avgRating.
    */

    public String getAvgRating() {
        return avgRating;
    }
    /**
    @return the current value of totRating.
    */
    public String getTotRating() {
        return totRating;
    }
    /**
    @return the current value of date.
    */
    public String getDate() {
        return date;
    }


    /** Return a string representation of this object */
    @Override
    public String toString() {
        return
                "Average Rating: " + avgRating + '\n' +
                        "Total Rating: " + totRating + '\n' +
                        "Last Review Date: " + date ;
    }
}
