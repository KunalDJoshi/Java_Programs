import java.io.*;

public class BytePe1 {

    public static void main(String[] args) throws IOException {

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("ClassList.dat")));

        System.out.printf("%-20s %-15s %-10s %-10s %-10s %-10s %-10s\n", "Name", "ID", "Grade1", "Grade2", "Grade3", "Grade4", "Avg.");
        boolean eof = false;
        try {
            while (!eof) {

                String student = dis.readUTF();
                int number = dis.readInt();
                double grade1 = dis.readDouble();
                double grade2 = dis.readDouble();
                double grade3 = dis.readDouble();
                double grade4 = dis.readDouble();
                double avg = ((grade1 + grade2 + grade3 + grade4) / 4);

                System.out.printf("%-20s %-15d %-10.1f %-10.1f %-10.1f %-10.1f %-10.1f\n", student, number, grade1, grade2, grade3, grade4, avg);
            }

            dis.close();
        } catch (EOFException e) {
            eof = true;
        }

    }
}