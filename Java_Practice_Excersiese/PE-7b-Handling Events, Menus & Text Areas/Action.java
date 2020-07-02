public class Action implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        MyEventA mea = new MyEventA();
        if (e.getSource() == mea.jbtnplus)
            total = +1;
        txtName.setText(total);
    }
}