import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyMenu extends JFrame {

    JFrame frame = new JFrame("My Menu");
    private JTextArea txtTextArea;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu countMenu = new JMenu("Count");
    private JMenuItem incMenuItem = new JMenuItem("Inc");
    private JMenuItem decMenuItem = new JMenuItem("Dec");
    private JMenuItem rstMenuItem = new JMenuItem("Reset");
    private JMenuItem extMenuItem = new JMenuItem("Exit");
    private int numtxt = 0;

    public static void main(String[] args) {
        new MyMenu();
    }

    public MyMenu() {


        this.setJMenuBar(menuBar);
        frame.add(menuBar, BorderLayout.NORTH);
        menuBar.add(countMenu);
        countMenu.add(incMenuItem);
        countMenu.add(decMenuItem);
        countMenu.add(rstMenuItem);
        countMenu.add(extMenuItem);


        txtTextArea = new JTextArea(20, 15);
        frame.add(txtTextArea, BorderLayout.CENTER);
        txtTextArea.setWrapStyleWord(true);
        txtTextArea.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(txtTextArea);

        frame.add(jsp);
        txtTextArea.append(String.valueOf(numtxt) + '\n');

        ActionListener actionListener = new MyListnerCnt(numtxt, txtTextArea);
        incMenuItem.addActionListener(actionListener);
        decMenuItem.addActionListener(actionListener);
        rstMenuItem.addActionListener(actionListener);
        extMenuItem.addActionListener(actionListener);



        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}