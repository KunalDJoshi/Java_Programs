/**
 *Results class has Results constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-02
 */
public class Results {
    private String title;
    private String address;
    private String phone;
    Rating rating;

    /**
    This is constructor of Results class. 
    */
    public Results(String title, String address, String phone, Rating rating) {

        this.title = title;
        this.address = address;
        this.phone = phone;
        this.rating = rating;

    }

    /**
    @return the current value of title.
    */
    public String getTitle() {
        return title;
    }

    /**
    @return the current value of address.
    */
    public String getAddress() {
        return address;
    }

    /**
    @return the current value of phone.
    */
    public String getPhone() {
        return phone;
    }



    /** Return a string representation of this object */
    @Override
    public String toString() {
        return

                "title: " + title + '\n' +
                        "address: " + address + '\n' +
                        "phone: " + phone + '\n' +
                        rating + '\n' + '\n';

    }
}


