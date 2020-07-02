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

    public static void main(String[] args) {
        new OrdersScreen();
    }

    /**
    This is constructor of OrdersScreen class. 
    */
    public OrdersScreen() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 1000);
        jcbVehicles.addItemListener(this);

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
    }

    /**
    This method gets invoked when an action occurs.
    @param ActionEvent.
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        } else if (e.getActionCommand().equals("About")) {
            JOptionPane.showMessageDialog(null, "Kunal Joshi \nHomework Assignment 7", "About", JOptionPane.PLAIN_MESSAGE);


        }
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
            choices = Car.getCarTypes();
            jcbConfig1.removeAllItems();
            for (String s: choices) {
                jcbConfig1.addItem(s);
            }

            jlConfig2.setText(attributeLabels[1]);
            choices = Car.getTowingPackage();
            jcbConfig2.removeAllItems();
            for (String s: choices) {
                jcbConfig2.addItem(s);
            }

        } else if (item.equals("Truck")) {


            attributeLabels = Truck.getAttributeLabels();

            jlConfig1.setText(attributeLabels[0]);
            choices = Truck.getTrucksizeChoices();
            jcbConfig1.removeAllItems();
            for (String s: choices) {
                jcbConfig1.addItem(s);
            }

            jlConfig2.setText(attributeLabels[1]);
            choices = Truck.getEngineSize();
            jcbConfig2.removeAllItems();
            for (String s: choices) {
                jcbConfig2.addItem(s);
            }
        } else if (item.equals("Boat")) {


            attributeLabels = Boat.getAttributeLabels();

            jlConfig1.setText(attributeLabels[0]);
            choices = Boat.getBoatypeChoices();
            jcbConfig1.removeAllItems();
            for (String s: choices) {
                jcbConfig1.addItem(s);
            }

            jlConfig2.setText(attributeLabels[1]);
            choices = Boat.getBoatConstruction();
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