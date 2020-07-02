/**
 *Races class extends JFrame.
 *Races class has Races constructor. 
 *This class used to make imgicons race across the screen by using GUI and Threads.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-11-11
 */
import javax.swing.*;
import java.awt.*;


public class Races extends JFrame {

    public static JFrame jframe;

    boolean stop = false;
    int inc = 0;
    ImageIcon imgicon = new ImageIcon("races.gif");
    int height = imgicon.getIconHeight();
    int width = imgicon.getIconHeight();
    int threadCount=0;



    /**
    This is the main method which calls animate() method.It accepts number of threads from command line.
    * @param args.
    * @return Nothing.
    */
    public static void main(String[] args) {
        if (args.length == 0) {
            (new Races(5)).animate();

        } else {
            (new Races(Integer.parseInt(args[0]))).animate();
        }

    }

    /**
    This is constructor of Races class. 
    * @param int _threadCount.
    */
    public Races(int _threadCount) {

        this.threadCount = _threadCount;
        initialize(threadCount);

    }

    /**
	This method is for setting JFrame. 
	@param int _threadCount.
   @return Nothing
	*/
    public void initialize(int _threadCount) {
        this.setVisible(true);
        this.threadCount = _threadCount;
        this.setLayout(new GridLayout(threadCount, 1));
        this.setTitle("Off to the Races- by Kunal Joshi");
        this.setSize((width * 20), (height * 3) * threadCount);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (inc < threadCount) {
            this.add(new RacerInnerClass("image " + (inc + 1)));
            inc++;
        }

    }

    /**
	This method is to sleep thread for 100ms and calls repaint() method.
	@param int _threadCount.
   @return Nothing
	*/
    private void animate() {

        while (true) {

            try {
                Thread.sleep(100);
            } catch (Exception ex) {}

            repaint();

            if (stop)
                break;
        }
    }

    /**
     *RacerInnerClass class is inner class of Races class which extends JPanel.
     *RacerInnerClass class has RacerInnerClass constructor. 
     *This class paint() method.
     */

    private class RacerInnerClass extends JPanel {
        String name;
        int x = 10;
        int end;

        /**
    This is constructor of RacerInnerClass class. 
    * @param String _name.
    */
        public RacerInnerClass(String _name) {
            this.name = _name;
        }


        /**
	This method is to paint this component.
	@param Graphics g.
   @return Nothing
	*/
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.BLACK);
            x = x + (int)(Math.random() * 5);


            end = (width * 20) - (width * 2);
            g.drawLine(end, 0, end, 2000);

            imgicon.paintIcon(this, g, x, (10));



            if (x > end - (width) && stop == false) {
                stop = true;

                jframe = new JFrame();
                System.out.println(name + " Win");
                g.drawString("Winner is: " + name, x, inc * 10);
                JOptionPane.showMessageDialog(jframe, " Winner is " + name + " at " + x + " " + inc * 10 + "");


            }
        }

    }
}