import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyEventC extends JFrame implements ActionListener {
    public int count = 0;
    JTextField txtName;
    JLabel lblName;
    JButton jbtnplus, jbtnminus, jbtnReset, jbtnQuit;
    public MyEventC() {
        //setLayout(new BorderLayout(5,10));
        //setting the layout for the JFrame
        setLayout(new BorderLayout());


        JPanel panelNorth = new JPanel();

        JPanel panelSouth = new JPanel();

        //adding JPanel on the JFrame
        add(panelNorth, BorderLayout.NORTH);
        add(panelSouth, BorderLayout.SOUTH);
        //pnl.setLayout(new  BorderLayout());
        this.setTitle("Part 4 Using separate class for Reset Button");
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
        ActionListener actionListener = new ResetListener(this, txtName);
        jbtnReset.addActionListener(actionListener);
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
        }
        /*   else if(ae.getActionCommand()=="Reset")
           {
            txtName.setText(Integer.toString(0));
           }*/
        else if (ae.getActionCommand() == "Quit") {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

        MyEventC jf = new MyEventC();
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setSize(400, 100);
        jf.setVisible(true);
    }

}