import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class symptomTracker extends JFrame implements ActionListener {
    private JFrame jFrame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton checkSyps, finished;
    private JButton findNearestDoc;
    private JLabel jLabel;
    private JPanel jPanel;
    private JLabel moment;
    private JPanel symptomPanel;
    // jButton Symptoms
    private JButton cough, fever, chills, shortOBreath, fatigue, muscOBodAche, headache, lossTaste, lossSmell,
            soreThroat, runnyNose, vomiting, congestion, nausea, diarrea;
    private JLabel whichSyps, currSyps;
    ArrayList<String> clientSyps = new ArrayList<String>();

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
        jPanel.setLayout(new GridLayout(2, 4));
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

    private void firstButtonOperation() {
        checkSyps = new JButton("Check off symptoms");
        checkSyps.addActionListener(new java.awt.event.ActionListener() {
            // This will be the transition action for the button which a new format will pop
            // up for the client (buttons with symptoms of covid they may have)
            public void actionPerformed(ActionEvent e) {
                // For a component to be removed effectively, revalidate must be used after
                jPanel.remove(checkSyps);
                jLabel.setVisible(false);
                // This will allow for the conponents of the frame to refactor your changes
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
        jFrame.setVisible(true);
        jPanel.setLayout(new FlowLayout());
        // expand size for new layout of buttons
        jFrame.setSize(600, 200);

        // instantiate new symptom buttons
        cough = new JButton("Cough");
        fever = new JButton("Fever");
        chills = new JButton("Chills");
        shortOBreath = new JButton("Shortness of breath or difficulty breathing");
        fatigue = new JButton("Fatigue");
        muscOBodAche = new JButton("Muscle or body aches");
        headache = new JButton("Headache");
        lossTaste = new JButton("New loss of taste");
        lossSmell = new JButton("New loss of smell");
        soreThroat = new JButton("Sore throat");
        congestion = new JButton("Congestion in nose");
        runnyNose = new JButton("Runny Nose");
        nausea = new JButton("Nausea");
        vomiting = new JButton("Vomiting");
        diarrea = new JButton("Diarrhea");
        finished = new JButton("CLICK WHEN FINISHED");

        // add new symptom buttons
        jPanel.add(cough);
        jPanel.add(fever);
        jPanel.add(chills);
        jPanel.add(shortOBreath);
        jPanel.add(fatigue);
        jPanel.add(muscOBodAche);
        jPanel.add(headache);
        jPanel.add(lossTaste);
        jPanel.add(lossSmell);
        jPanel.add(soreThroat);
        jPanel.add(congestion);
        jPanel.add(nausea);
        jPanel.add(vomiting);
        jPanel.add(diarrea);
        
        whichSyps = new JLabel("Select all symptoms which apply to you.", JLabel.CENTER);
        jPanel.add(whichSyps);
        jPanel.add(finished);

        // adding action listeners for each symptom button
        cough.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Cough")) {
                    clientSyps.add("Cough");
                }
                // MAYBE rating how bad 1-10 it is?
            }
        });
        fever.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Fever")) {
                    clientSyps.add("Fever");
                }
                // popup that says that this has already been added (new private method?)
            }
        });
        chills.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Chills")) {
                    clientSyps.add("Chills");
                }

            }
        });
        shortOBreath.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Shortness of breath or difficulty breathing")) {
                    clientSyps.add("Shortness of Breath or difficulty breathing");
                }
            }
        });
        fatigue.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Fatigue")) {
                    clientSyps.add("Fatigue");
                }
            }
        });
        muscOBodAche.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Muscle or body aches")) {
                    clientSyps.add("Muscle or body aches");
                }
            }
        });
        headache.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Headache")) {
                    clientSyps.add("Headache");
                }
            }
        });
        lossTaste.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("New loss of taste")) {
                    clientSyps.add("New loss of taste");
                }
            }
        });
        lossSmell.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("New loss of smell")) {
                    clientSyps.add("New loss of smell");
                }
            }
        });
        soreThroat.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Sore throat")) {
                    clientSyps.add("Sore throat");
                }
            }
        });
        congestion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Congestion")) {
                    clientSyps.add("Congestion");
                }

            }
        });
        nausea.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Nausea")) {
                    clientSyps.add("Nausea");
                }

            }
        });
        vomiting.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Vomiting")) {
                    clientSyps.add("Vomiting");
                }
            }
        });
        diarrea.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientSyps.contains("Diarrhea")) {
                    clientSyps.add("Diarrhea");
                }
            }
        });
        finished.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove all of the button and labels from this previous window for new window
                jPanel.remove(cough);
                jPanel.remove(fever);
                jPanel.remove(chills);
                jPanel.remove(shortOBreath);
                jPanel.remove(fatigue);
                jPanel.remove(muscOBodAche);
                jPanel.remove(headache);
                jPanel.remove(lossSmell);
                jPanel.remove(lossTaste);
                jPanel.remove(soreThroat);
                jPanel.remove(congestion);
                jPanel.remove(nausea);
                jPanel.remove(vomiting);
                jPanel.remove(diarrea);

                jPanel.remove(whichSyps);
                jPanel.remove(finished);
                //Again, updating all of the removed components to move onto the next window
                jPanel.revalidate();
                jPanel.setVisible(false);
                lastPage();
            }
        });
    }

    private void lastPage() {
       currSyps = new JLabel("These are all the symptoms you have just provided that you have:", JLabel.CENTER);
       jPanel.setLayout(new FlowLayout());
       jPanel.add(currSyps);
       jPanel.setVisible(true);

    }

    public static void main(String args[]) {
        symptomTracker newTracker = new symptomTracker();
        newTracker.firstButtonOperation();
    }
}