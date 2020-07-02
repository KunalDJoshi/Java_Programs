/**
 *OrdersScreen class implements ActionListener, ItemListener.
 *OrdersScreen class has OrdersScreen constructor. 
 *This class used to make GUI of Vehicle Ordering system.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-10-29
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.io.*;

public class OrdersScreen extends JFrame implements ActionListener, ItemListener {
    private JLabel lbltitle1 = new JLabel("Kunal Joshi's ", SwingConstants.RIGHT);
    String[] VEHICLE_LIST = {
        "Select Vehicle .. ",
        "Car",
        "Truck",
        "Boat"
    };

    private JLabel lblvehicletype = new JLabel("Vehicle type:", SwingConstants.RIGHT);
    private JLabel jlConfig1 = new JLabel("", JLabel.RIGHT);
    private JLabel jlConfig2 = new JLabel("", JLabel.RIGHT);

    private JLabel lbltitle12 = new JLabel("Ordering System", SwingConstants.LEFT);
    private JLabel lblmodel = new JLabel("Model", SwingConstants.RIGHT);
    private JLabel lblcolor = new JLabel("Color", SwingConstants.RIGHT);
    private JLabel lblcost = new JLabel("Cost", SwingConstants.RIGHT);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem loadMenuItem = new JMenuItem("Load");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");
    private JMenuItem aboutMenuItem = new JMenuItem("About");

    private JTextField txtmodel = new JTextField(25);
    private JTextField txtcolor = new JTextField(25);
    private JTextField txtcost = new JTextField(25);

    private JComboBox jcbVehicles = new JComboBox(VEHICLE_LIST);
    private JComboBox jcbConfig1 = new JComboBox();
    private JComboBox jcbConfig2 = new JComboBox();

    private JButton btnSave = new JButton("SAVE");
    private JButton btnFirst = new JButton("FIRST");
    private JButton btnPrev = new JButton("PREV");
    private JButton btnNext = new JButton("NEXT");
    private JButton btnLast = new JButton("LAST");
    private JButton btnExit = new JButton("Exit");

    private JPanel panelOrders = new JPanel();
    private JPanel panelButton = new JPanel();



    JFrame frame = new JFrame("Orders");


    ArrayList < Object > orders = new ArrayList < > ();
    private int count = 0;
    private String fileName = "VehicleOrders.dat";
    File file = new File(fileName);

    public static void main(String[] args) {
        new OrdersScreen();
    }

    /**
    This is constructor of OrdersScreen class. 
    */
    public OrdersScreen() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 1000);
        // jcbVehicles.addItemListener(this);

        //Order Panel by using GridLayout

        panelOrders.setLayout(new GridLayout(7, 2, 5, 10));
        panelOrders.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelOrders.setMinimumSize(new Dimension(800, 100));
        frame.add(panelOrders, BorderLayout.CENTER);
        Font f = new Font("", Font.BOLD, 25);
        lbltitle1.setFont(f);
        lbltitle1.setForeground(Color.red);
        lbltitle12.setFont(f);
        lbltitle12.setForeground(Color.red);

        //Adding components into JPanel for Orders
        panelOrders.add(lbltitle1);
        panelOrders.add(lbltitle12);
        panelOrders.add(lblvehicletype);
        panelOrders.add(jcbVehicles);
        panelOrders.add(lblmodel);
        panelOrders.add(txtmodel);
        panelOrders.add(lblcolor);
        panelOrders.add(txtcolor);
        panelOrders.add(lblcost);
        panelOrders.add(txtcost);
        panelOrders.add(jlConfig1);
        panelOrders.add(jcbConfig1);
        panelOrders.add(jlConfig2);
        panelOrders.add(jcbConfig2);

        //Adding MenuBar to JFrame
        frame.add(menuBar, BorderLayout.NORTH);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        fileMenu.add(loadMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        helpMenu.add(aboutMenuItem);
        btnExit.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);

        //Button panel Using FlowLayout. Adding it to JFrame.

        panelButton.setLayout(new FlowLayout());
        frame.add(panelButton, BorderLayout.SOUTH);

        //Adding components into JPanel for Button
        panelButton.add(btnSave);
        panelButton.add(btnFirst);
        panelButton.add(btnPrev);
        panelButton.add(btnNext);
        panelButton.add(btnLast);
        panelButton.add(btnExit);

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        //ActionListeners
        btnExit.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
        loadMenuItem.addActionListener(this);
        btnSave.addActionListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrev.addActionListener(this);
        jcbVehicles.addItemListener(this);
    }


    /**
    	This method is for saving the vehicle order to array list and write the data to output file . Upon exit of the program, write the ordered data to a VehicleOrders.dat file that
       can be read in upon the next run of this program. It appends the new data at the end of previous data in VehicleOrders.dat file.
       @return Nothing.
       * @exception IOException On input error.
       * @see IOException
    	*/


    public void saveOrder() throws FileNotFoundException {
        try {
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter buffer = new BufferedWriter(writer);

            for (Object orderlist: orders) {
                buffer.write(orderlist + "|");

            }
            buffer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }



    /**
    	This method is to read the orders that were written out to the file at the end of the previous run.
       @return Nothing.
       * @exception FileNotFoundException for not finding file error.
       * @see FileNotFoundException
    	*/
    public void loadOrder() throws FileNotFoundException {
        if (file.exists()) {
            FileInputStream fileIn = new FileInputStream(fileName);
            Scanner scan = new Scanner(fileIn);
            scan.useDelimiter("\\|");
            while (scan.hasNext()) {

                orders.add(scan.next());

            }

            count = 0;
            JOptionPane.showMessageDialog(null, orders.get(count), "First Order", JOptionPane.PLAIN_MESSAGE);


        } else {
            JOptionPane.showMessageDialog(null, "File not Found", null, JOptionPane.WARNING_MESSAGE);
        }
    }


    /**
    	This method is to save the data from the screen to the ArrayList of orders .
       @return Nothing.
    	*/
    public void saveItem() {
        if (jcbVehicles.getSelectedItem().equals("Car")) {
            Car car = new Car(txtmodel.getText(), txtcolor.getText(), Double.parseDouble(txtcost.getText()), (String) jcbConfig1.getSelectedItem(),
                (String) jcbConfig2.getSelectedItem());

            orders.add(car);

            JOptionPane.showMessageDialog(null, "Order Saved", "Save", JOptionPane.INFORMATION_MESSAGE);
            count++;
            clearTextField();
        } else if (jcbVehicles.getSelectedItem().equals("Boat")) {
            Boat boat = new Boat(txtmodel.getText(), txtcolor.getText(), Double.parseDouble(txtcost.getText()), (String) jcbConfig1.getSelectedItem(),
                (String) jcbConfig2.getSelectedItem());

            orders.add(boat);

            JOptionPane.showMessageDialog(null, "Order Saved", "Save", JOptionPane.INFORMATION_MESSAGE);
            count++;
            clearTextField();
        } else if (jcbVehicles.getSelectedItem().equals("Truck")) {
            Truck truck = new Truck(txtmodel.getText(), txtcolor.getText(), Double.parseDouble(txtcost.getText()), (String) jcbConfig1.getSelectedItem(),
                (String) jcbConfig2.getSelectedItem());

            orders.add(truck);

            JOptionPane.showMessageDialog(null, "Order Saved", "Save", JOptionPane.INFORMATION_MESSAGE);
            count++;
            clearTextField();
        }

    }

    /**
    This method gets invoked when an action occurs.
    @param ActionEvent.
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            try {
                saveOrder();
            } catch (FileNotFoundException f) {
                f.printStackTrace();
            }
            System.exit(0);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        } else if (e.getActionCommand().equals("About")) {
            JOptionPane.showMessageDialog(null, "Kunal Joshi \nHomework Assignment 7", "About", JOptionPane.PLAIN_MESSAGE);


        } else if (e.getActionCommand().equals("SAVE")) {
            saveItem();


        } else if (e.getActionCommand().equals("Load")) {
            try {
                loadOrder();
            } catch (FileNotFoundException f) {
                f.printStackTrace();
            }

        } else if (e.getActionCommand().equals("FIRST")) {
            count = 0;
            Object first = orders.get(count);
            JOptionPane.showMessageDialog(null, first, "First Order", JOptionPane.PLAIN_MESSAGE);


        } else if (e.getActionCommand().equals("PREV")) {

            try {
                count--;
                JOptionPane.showMessageDialog(null, orders.get(count), "Previous Order", JOptionPane.PLAIN_MESSAGE);

            } catch (IndexOutOfBoundsException ie) {
                JOptionPane.showMessageDialog(null, orders.get(0) + "\n\n Reached First Order", "First Order", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getActionCommand().equals("NEXT")) {
            try {
                if (count < orders.size()) {

                    count++;
                    JOptionPane.showMessageDialog(null, orders.get(count), "Next Order", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (IndexOutOfBoundsException ie) {
                JOptionPane.showMessageDialog(null, orders.get(orders.size() - 1) + "\n\n Reached Last Order", "Last Order", JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getActionCommand().equals("LAST")) {
            count = orders.size() - 1;
            Object last = orders.get(count);
            JOptionPane.showMessageDialog(null, last, "Last Order", JOptionPane.PLAIN_MESSAGE);

        }
    }

    /**
    This method is for making JTextFields empty.
    @return Nothing.
    */

    public void clearTextField() {
        txtmodel.setText("");
        txtcolor.setText("");
        txtcost.setText("");
        jcbConfig1.removeAllItems();
        jlConfig1.setText("");
        jcbConfig2.removeAllItems();
        jlConfig2.setText("");
        jcbVehicles.setSelectedIndex(0);
    }




    /**
    This method gets invoked 2 times when a value is selected.First time when the current value is UNSELECTED.Second time when the a new value is SELECTED.
    @param ItemEvent.
    */
    public void itemStateChanged(ItemEvent ie) {
        String[] attributeLabels;
        String[] choices;


        int state = ie.getStateChange();
        if (state != ItemEvent.SELECTED)
            return;

        String item = (String) ie.getItem();
        System.out.println(item);

        if (item.equals("Car")) {
            System.out.println("Chose a " + item);

            attributeLabels = Car.getAttributeLabels();

            jlConfig1.setText(attributeLabels[0]);
            choices = Car.getCarTypesarr();
            jcbConfig1.removeAllItems();
            for (String s: choices) {
                jcbConfig1.addItem(s);
            }

            jlConfig2.setText(attributeLabels[1]);
            choices = Car.getTowingPackagearr();
            jcbConfig2.removeAllItems();
            for (String s: choices) {
                jcbConfig2.addItem(s);
            }

        } else if (item.equals("Truck")) {


            attributeLabels = Truck.getAttributeLabels();

            jlConfig1.setText(attributeLabels[0]);
            choices = Truck.getTrucksizeChoicesarr();
            jcbConfig1.removeAllItems();
            for (String s: choices) {
                jcbConfig1.addItem(s);
            }

            jlConfig2.setText(attributeLabels[1]);
            choices = Truck.getEngineSizearr();
            jcbConfig2.removeAllItems();
            for (String s: choices) {
                jcbConfig2.addItem(s);
            }
        } else if (item.equals("Boat")) {


            attributeLabels = Boat.getAttributeLabels();

            jlConfig1.setText(attributeLabels[0]);
            choices = Boat.getBoatypeChoicesarr();
            jcbConfig1.removeAllItems();
            for (String s: choices) {
                jcbConfig1.addItem(s);
            }

            jlConfig2.setText(attributeLabels[1]);
            choices = Boat.getBoatConstructionarr();
            jcbConfig2.removeAllItems();
            for (String s: choices) {
                jcbConfig2.addItem(s);
            }
        } else {
            jlConfig1.setText("");
            jcbConfig1.removeAllItems();
        }


    }

}