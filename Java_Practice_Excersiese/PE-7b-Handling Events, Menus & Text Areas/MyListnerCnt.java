import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListnerCnt implements ActionListener {

    private int num;
    private JTextArea txtarea;

    public MyListnerCnt(int num, JTextArea txtarea) {
        this.num = num;
        this.txtarea = txtarea;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Inc")) {
            this.num += 1;
            this.txtarea.append(String.valueOf(this.num) + '\n');
        } else if (e.getActionCommand().equals("Dec")) {
            this.num -= 1;
            this.txtarea.append(String.valueOf(this.num) + '\n');
        } else if (e.getActionCommand().equals("Reset")) {
            this.num = 0;
            this.txtarea.append(String.valueOf(this.num) + '\n');
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);

        }

    }
}