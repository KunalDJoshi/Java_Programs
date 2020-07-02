import java.io.*;
import java.util.*;
public class BytePe4 {
   // ArrayList < Integer > arr = new ArrayList < Integer > ();
   
            int List;
   List al = Collections.synchronizedList(new ArrayList());
   
       public static void main(String args[]) {
         new BytePe4();


    }
	
	public BytePe4()
    {
     ReadInts thread1= new ReadInts("integer1.dat");
     ReadInts thread2= new ReadInts("integer2.dat");
     ReadInts thread3= new ReadInts("integer3.dat");
     ReadInts thread4= new ReadInts("integer4.dat");
     ReadInts thread5= new ReadInts("integer5.dat");
     ReadInts thread6= new ReadInts("integer6.dat");
     ReadInts thread7= new ReadInts("integer7.dat");
     ReadInts thread8= new ReadInts("integer8.dat");
      thread1.start();
      thread2.start();
     thread3.start();
     thread4.start();
     thread5.start();
     thread6.start();
     thread7.start();
     thread8.start();
    }

    public class ReadInts extends Thread{
        String file;
         int i = 0;
         int count = 0;
          int sum = 0;
         int in_list = 0;
       

        public ReadInts(String _file) {
        this.file=_file;
        }
        
        public void run(){ 
             
            try {
                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
                while (dis.available()>0) {
                   i=dis.readInt();
                   //synchronized(arr){
                    al.add(i);
                    count++;
                    sum=sum+i; 
                  //  }                                  
                }
                 System.out.println("Filename = " + file + "   Count = " + count + "   Sum = " + sum + "In List = " + al.size());
                 dis.close();                 
                 
            } catch (FileNotFoundException fne) {
            // System.out.println("Filename = " + file + "   Count = " + count + "   Sum = " + sum + "In List = " + arr.size());
                System.out.println("File does not exist: " + file);
                //System.out.println("Filename = " + file + "   Count = " + count + "   Sum = " + sum + "In List = " + arr.size());

                //System.exit(0);
            } catch (Exception ioe) {
               System.out.println("exception"+ioe.getMessage());
               //System.out.println("Filename = " + file + "   Count = " + count + "   Sum = " + sum + "In List = " + arr.size());
              }
            /*count = 0;
            sum = 0;
            for (int j: arr) {
                count++;
                sum = sum + j;
                in_list++;
            }
            arr.clear();*/

           // System.out.println("Filename = " + file + "   Count = " + count + "   Sum = " + sum + "In List = " + in_list);

        }

    }
    
    

  /*  public void BytePe4Method() {
        AddIntsClass aic = new AddIntsClass();
        aic.addInts("integer1.dat");
        aic.addInts("integer2.dat");
        aic.addInts("integer3.dat");
        aic.addInts("integer4.dat");
        aic.addInts("integer5.dat");
        aic.addInts("integer6.dat");
        aic.addInts("integer7.dat");
        aic.addInts("integer8.dat");
    }*/
}