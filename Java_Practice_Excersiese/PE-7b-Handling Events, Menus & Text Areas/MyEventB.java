import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyEventB extends JFrame implements ActionListener {
    private int count = 0;
    JTextField txtName;
    JLabel lblName;
    JButton jbtnplus, jbtnminus, jbtnReset, jbtnQuit;
    public MyEventB() {
        //setLayout(new BorderLayout(5,10));
        //setting the layout for the JFrame
        setLayout(new BorderLayout());


        JPanel panelNorth = new JPanel();

        JPanel panelSouth = new JPanel();

        //adding JPanel on the JFrame
        add(panelNorth, BorderLayout.NORTH);
        add(panelSouth, BorderLayout.SOUTH);
        //pnl.setLayout(new  BorderLayout());
        this.setTitle("Part 3 Using getActionCommand");
        lblName = new JLabel("Current Value:", SwingConstants.RIGHT);
        txtName = new JTextField("0", 10);

        lblName.setLabelFor(txtName);

        panelNorth.add(lblName, BorderLayout.CENTER);
        panelNorth.add(txtName, BorderLayout.CENTER);

        add(panelNorth, BorderLayout.CENTER);

        jbtnplus = new JButton("+");
        jbtnminus = new JButton("-");
        jbtnReset = new JButton("Reset");
        jbtnQuit = new JButton("Quit");

        panelSouth.add(jbtnplus, BorderLayout.SOUTH);
        panelSouth.add(jbtnminus, BorderLayout.SOUTH);
        panelSouth.add(jbtnReset, BorderLayout.SOUTH);
        panelSouth.add(jbtnQuit, BorderLayout.SOUTH);

        jbtnplus.addActionListener(this);
        jbtnminus.addActionListener(this);
        jbtnReset.addActionListener(this);
        jbtnQuit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("+")) {
            //System.out.println("+ is clicked");
            count++;
            txtName.setText(Integer.toString(count));
        } else if (ae.getActionCommand() == "-") {
            // System.out.println("- is clicked");
            count--;
            txtName.setText(Integer.toString(count));
        } else if (ae.getActionCommand() == "Reset") {
           count=0;
         //  String a= txtName.getText();
            txtName.setText(Integer.toString(0));
        } else if (ae.getActionCommand() == "Quit") {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

        MyEventB jf = new MyEventB();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setSize(400, 100);
        jf.setVisible(true);
    }

}