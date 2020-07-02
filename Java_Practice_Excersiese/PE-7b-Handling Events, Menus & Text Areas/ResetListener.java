import java.awt.event.*;
import javax.swing.*;

public class ResetListener implements ActionListener {
    MyEventC obj;
    JTextField txtName;
    JLabel lblName;
    JButton jbtnReset;

    public ResetListener(MyEventC obj, JTextField txtName) {
        this.obj = obj;
        this.txtName = txtName;


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand() == "Reset") {
            obj.count=0;
            txtName.setText(Integer.toString(0));
        }
    }



}