import java.io.*;
import java.util.*;
public class BytePe2 {
    public static void main(String args[]) {
        String file = "integer7.dat";
        ArrayList < Integer > arr = new ArrayList < Integer > ();
        int i = 0;
        int count = 0;
        int sum = 0;

        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            while ((i = dis.readInt()) != -1) {
                arr.add(i);
            }
            dis.close();
        } catch (IOException ioe) {

        }

        for (int j: arr) {
            //System.out.println(j);
            count++;
            sum = sum + j;
        }
        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
        System.out.println("In List = " + count);
    }
}