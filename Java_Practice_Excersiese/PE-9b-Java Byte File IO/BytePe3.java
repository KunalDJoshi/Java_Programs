import java.io.*;
import java.util.*;
public class BytePe3 {
    ArrayList < Integer > arr = new ArrayList < Integer > ();
    int i = 0;
    int count = 0;
    int sum = 0;
    int in_list = 0;

    public static void main(String args[]) {
        BytePe3 be = new BytePe3();
        be.BytePe3Method();

    }

    public class AddIntsClass {
        public void addInts(String file) {
            try {
                i = 0;
                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

                while ((i = dis.readInt()) != -1) {
                    arr.add(i);
                }
                dis.close();
            } catch (FileNotFoundException fne) {
                System.out.println("File does not exist: " + file);
                System.exit(0);
            } catch (IOException ioe) {

            }
            count = 0;
            sum = 0;
            for (int j: arr) {
                count++;
                sum = sum + j;
                in_list++;
            }
            arr.clear();

            System.out.println("Filename = " + file + "   Count = " + count + "   Sum = " + sum + "In List = " + in_list);

        }

    }

    public void BytePe3Method() {
        AddIntsClass aic = new AddIntsClass();
        aic.addInts("integer1.dat");
        aic.addInts("integer2.dat");
        aic.addInts("integer3.dat");
        aic.addInts("integer4.dat");
        aic.addInts("integer5.dat");
        aic.addInts("integer6.dat");
        aic.addInts("integer7.dat");
        aic.addInts("integer8.dat");
    }
}