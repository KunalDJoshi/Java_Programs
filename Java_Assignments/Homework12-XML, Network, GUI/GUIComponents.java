/**
 *GUIComponents class has GUIComponents constructor and implements ActionListener. 
 *This class is for displaying XML data on GUI.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-02
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import org.xml.sax.SAXException;


public class GUIComponents {
    private ParserClass dvc;
    private DefaultTableModel dtm;
    private JFrame GUIComponentsBuilder;
    private JPanel jpnlrbtn;
    private JRadioButton jrbtnRoc;
    private JRadioButton jrbtnSanF;
    private JButton jrbtnOK;
    private JButton jrbtnXML;
    private JPanel jpnltbl;
    private JScrollPane scrollPane;
    private JTable jtbl;
    private ButtonGroup buttonGroup;
    private ArrayList < Results > res;
    private String[] header = new String[] {
        "Title",
        "Address",
        "Phone",
        "Average Ratings",
        "Total Ratings",
        "Date Of Last Ratings"
    };
    private String file = "";
    private String fname = "";

    /**
    This is constructor of GUIComponents class. 
    */
    public GUIComponents() {

        guiScreen();
    }

    /**
    This method is for creating GUI.
    */
    private void guiScreen() {

        GUIComponentsBuilder = new JFrame();
        jpnlrbtn = new JPanel();
        jrbtnOK = new JButton();
        jrbtnXML = new JButton();
        jpnltbl = new JPanel();
        scrollPane = new JScrollPane();
        jtbl = new JTable();
        jrbtnRoc = new JRadioButton("RochesterSushi.xml");
        jrbtnSanF = new JRadioButton("SanFranciscoSushi.xml");


        // Adding radio buttons in jpanel
        GUIComponentsBuilder.add(jpnlrbtn, BorderLayout.NORTH);
        jpnlrbtn.add(jrbtnRoc);
        jpnlrbtn.add(jrbtnSanF);
        jpnlrbtn.add(jrbtnOK);
        jpnlrbtn.add(jrbtnXML);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jrbtnRoc);
        buttonGroup.add(jrbtnSanF);

        //Adding radio button for OK
        jrbtnOK.setText("OK");
        jpnlrbtn.add(jrbtnOK);

        //Adding radio button for Create XML
        jrbtnXML.setText("Create XML");
        jpnlrbtn.add(jrbtnXML);


        //Jtable panel
        jpnltbl.setLayout(new BorderLayout());

        //Adding Scroll Pane for Jtable
        jtbl.setRowHeight(25);
        scrollPane.setViewportView(jtbl);
        jpnltbl.add(scrollPane, BorderLayout.CENTER);
        
         //Adding radio button for Rochester
        jrbtnRoc.setText("RochesterSushi.xml");
        jpnlrbtn.add(jrbtnRoc);

        //Adding radio button for SanFrancisco
        jrbtnSanF.setText("SanFranciscoSushi.xml");
        jpnlrbtn.add(jrbtnSanF);


        //creating Action Listener 
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("OK")) {
                    for (Enumeration < AbstractButton > buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                        AbstractButton button = buttons.nextElement();
                        if (button.isSelected()) {
                            if (button.getText().equals("RochesterSushi.xml")) {
                                fname = "RochesterSushi.xml";
                            } else if (button.getText().equals("SanFranciscoSushi.xml")) {
                                fname = "SanFranciscoSushi.xml";
                            }
                        } else if (!button.isSelected()) {
                            fname = "RochesterSushi.xml";
                        }
                    }
                    try {
                        dvc = new ParserClass(fname);
                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace();
                    } catch (XPathExpressionException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (SAXException ex) {
                        ex.printStackTrace();
                    }
                    res = dvc.parse();
                    dtm = new DefaultTableModel(header, 0);
                    jtbl.setModel(dtm);

                    dtm.setRowCount(0);
                    for (Results resultset: res) {
                        Object[] obj = {
                            resultset.getTitle(),
                            resultset.getAddress(),
                            resultset.getPhone(),
                            resultset.rating.getAvgRating(),
                            resultset.rating.getTotRating(),
                            resultset.rating.getDate()
                        };
                        dtm.addRow(obj);
                    }


                    jtbl.setEnabled(false);

                }
                if (e.getActionCommand().equals("Create XML")) {
                    try {
                        for (Enumeration < AbstractButton > buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();
                            if (button.isSelected()) {
                                if (button.getText().equals("RochesterSushi.xml")) {
                                    file = "RochesterSushi";
                                } else if (button.getText().equals("SanFranciscoSushi.xml")) {
                                    file = "SanFranciscoSushi";
                                }
                            } else if (!button.isSelected()) {
                                file = "RochesterSushi";
                            }
                        }
                        fname = file + ".xml";
                        dvc = new ParserClass(fname);
                        res = dvc.parse();

                        dvc.writeXML(file, res);

                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace();
                    } catch (XPathExpressionException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (SAXException ex) {
                        ex.printStackTrace();
                    } catch (XMLStreamException xms) {
                        xms.printStackTrace();
                    }


                }


            }
        };

        //Adding Action Listeners to components

        jrbtnOK.addActionListener(actionListener);
        jrbtnXML.addActionListener(actionListener);
        jrbtnRoc.addActionListener(actionListener);
        jrbtnSanF.addActionListener(actionListener);

        GUIComponentsBuilder.pack();
        GUIComponentsBuilder.setSize(1000, 400);
        GUIComponentsBuilder.setVisible(true);
        GUIComponentsBuilder.add(jpnltbl, BorderLayout.CENTER);
        GUIComponentsBuilder.setLocationRelativeTo(null);
        GUIComponentsBuilder.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


}