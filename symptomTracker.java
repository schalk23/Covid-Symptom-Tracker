import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class symptomTracker extends JFrame implements ActionListener {
    private JFrame jFrame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton checkSyps;
    private JButton findNearestDoc;
    private JLabel jLabel;
    private JPanel jPanel;
    private JLabel moment;
    private JPanel symptomPanel;

    public symptomTracker() {
        setGUI();
    }

    private void setGUI() {
        // creating the new swing components
        jFrame = new JFrame();
        textArea = new JTextArea();
        textField = new JTextField();
        checkSyps = new JButton("Check off symptoms");
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        jLabel = new JLabel("Select the option which best suits your needs.", JLabel.CENTER);
        // findNearestDoc = new JButton("Find nearest medical help");
        /*
         * We need to extend the JFrame in order to be able to use this jFrame action
         * and set default look of jFrame
         */
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setTitle(" Covid-19 Tracker and Interative Treatment Bot");
        jFrame.setSize(500, 200);
        jPanel.add(jLabel);
        // jPanel.add(findNearestDoc);
        jFrame.add(jPanel);
    }

    private void buttonOperation() {
        checkSyps = new JButton("Check off symptoms");
        checkSyps.addActionListener(new java.awt.event.ActionListener() {
            // This will be the transition action for the button which a new format will pop
            // up for the client (checkboxes with symptoms of covid they may have)
            public void actionPerformed(ActionEvent e) {
                //For a component to be removed effectively, revalidate must be used after
                jPanel.remove(checkSyps);
                jLabel.setVisible(false);
                //This will allow for the conponents of the frame to refactor your changes
                jPanel.revalidate();
                symptomPopup();
            }
        });
        // Putting this here moved the button below the label text and allowed the
        // method to run and the actions to execute
        jPanel.add(checkSyps);
        jFrame.setVisible(true);
    }

    private void symptomPopup() {
        
        jFrame.setVisible(false);
        
        // momentary jLabel
        moment = new JLabel("One moment...", JLabel.CENTER);
        symptomPanel = new JPanel();
        //jLabel component must get removed and refactored
        symptomPanel.setLayout(new GridLayout(2,1));
        jPanel.add(moment);
        jFrame.add(symptomPanel);
        
        jFrame.setVisible(true);
    }

    public static void main(String args[]) {
        symptomTracker newTracker = new symptomTracker();
        newTracker.buttonOperation();
    }
}