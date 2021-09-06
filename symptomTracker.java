
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class symptomTracker extends JFrame implements ActionListener {
    private JFrame jFrame;
    private JTextArea textArea;
    private JButton checkSyps, finished, goBack, end;
    private JButton findNearestDoc;
    private JLabel jLabel;
    private JPanel jPanel;
    private JLabel mustHaveSymp, contactProvider1, contactProvider2, contactProvider3;
    boolean haveSymptrue;
    // jButton Symptoms
    private JButton cough, fever, chills, shortOBreath, fatigue, muscOBodAche, headache, lossTaste, lossSmell,
            soreThroat, runnyNose, vomiting, congestion, nausea, diarrhea;
    private JLabel whichSyps, currSyps;
    private ArrayList<String> clientSyps = new ArrayList<String>();
    private Component area11, area12;

    public symptomTracker() {
        setGUI();
    }

    private void setGUI() {
        // creating the new swing components
        haveSymptrue = false;
        jFrame = new JFrame();
        textArea = new JTextArea();
        checkSyps = new JButton("Check off symptoms");
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jLabel = new JLabel("Click 'check off symptoms' to begin logging your Covid-19 symptoms.", JLabel.CENTER);
        jLabel.setAlignmentX(CENTER_ALIGNMENT);
        jLabel.setAlignmentY(CENTER_ALIGNMENT);
        Font text1 = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        jLabel.setFont(text1);
        area11 = Box.createRigidArea(new Dimension(0, 35));
        jPanel.add(area11);
        // findNearestDoc = new JButton("Find nearest medical help");
        /*
         * We need to extend the JFrame in order to be able to use this jFrame action
         * and set default look of jFrame
         */
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setTitle(" Covid-19 Symptom Tracker");
        jFrame.setSize(700, 300);
        jPanel.add(jLabel);
        // jPanel.add(findNearestDoc);
        jFrame.add(jPanel);
    }

    private void firstButtonOperation() {
        area12 = Box.createRigidArea(new Dimension(0, 35));
        jPanel.add(area12);
        checkSyps = new JButton("Check off symptoms");
        checkSyps.setAlignmentX(CENTER_ALIGNMENT);
        checkSyps.setAlignmentY(CENTER_ALIGNMENT);
        checkSyps.addActionListener(new java.awt.event.ActionListener() {
            // This will be the transition action for the button which a new format will pop
            // up for the client (buttons with symptoms of covid they may have)
            public void actionPerformed(ActionEvent e) {
                // For a component to be removed effectively, revalidate must be used after
                jPanel.remove(checkSyps);
                jLabel.setVisible(false);
                // This will allow for the conponents of the frame to refactor your changes
                jPanel.revalidate();
                symptomPopup(clientSyps);
            }
        });
        // Putting this here moved the button below the label text and allowed the
        // method to run and the actions to execute
        jPanel.add(checkSyps);
        jFrame.setVisible(true);
    }

    /*
     * This arraylist variable is passed in so that we are able to keep track of the
     * arraylist if the client decides to go back so that we do not have repeat
     * symptoms
     */
    private void symptomPopup(ArrayList<String> clientSyps1) {
        // if anything is weird happening this is the issue, made these rigid areas
        // private components
        // and this will keep on removing them here so they are not added, since if they
        // are removed anywhere
        // else they will no longer be visible
        jPanel.remove(area11);
        jPanel.remove(area12);
        revalidate();
        Component area7 = Box.createRigidArea(new Dimension(0, 35));
        jPanel.add(area7);
        jFrame.setVisible(true);
        jPanel.setLayout(new FlowLayout());
        // expand size for new layout of buttons
        jFrame.setSize(450, 300);

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
        diarrhea = new JButton("Diarrhea");
        finished = new JButton("CLICK WHEN FINISHED");

        // add new symptom buttons
        jPanel.add(cough);
        jPanel.add(fever);
        jPanel.add(chills);
        jPanel.add(shortOBreath);
        Component area8 = Box.createRigidArea(new Dimension(0, 35));
        jPanel.add(area8);
        jPanel.add(fatigue);
        jPanel.add(muscOBodAche);
        jPanel.add(headache);
        jPanel.add(lossTaste);
        jPanel.add(shortOBreath);
        Component area9 = Box.createRigidArea(new Dimension(0, 35));
        jPanel.add(area9);
        jPanel.add(lossSmell);
        jPanel.add(soreThroat);
        jPanel.add(congestion);
        Component area10 = Box.createRigidArea(new Dimension(0, 35));
        jPanel.add(area10);
        jPanel.add(runnyNose);
        jPanel.add(nausea);
        jPanel.add(vomiting);
        jPanel.add(diarrhea);

        Component area5 = Box.createRigidArea(new Dimension(0, 18));
        jPanel.add(area5);
        whichSyps = new JLabel("Select all symptoms which apply to you.", JLabel.CENTER);
        Component area6 = Box.createRigidArea(new Dimension(0, 18));
        jPanel.add(area6);
        Font text2 = new Font(Font.SANS_SERIF, Font.BOLD, 17);
        whichSyps.setFont(text2);
        jPanel.add(whichSyps);
        finished.setBackground(Color.BLACK);
        finished.setForeground(Color.WHITE);
        jPanel.add(finished);

        // adding action listeners for each symptom button
        cough.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cough.setBackground(Color.yellow);
                if (!clientSyps1.contains("Cough")) {
                    clientSyps1.add("Cough");
                }
                // MAYBE rating how bad 1-10 it is?
            }
        });
        fever.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fever.setBackground(Color.yellow);
                if (!clientSyps1.contains("Fever")) {
                    clientSyps1.add("Fever");
                }
                // popup that says that this has already been added (new private method?)
            }
        });
        chills.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chills.setBackground(Color.yellow);
                if (!clientSyps1.contains("Chills")) {
                    clientSyps1.add("Chills");
                }

            }
        });
        shortOBreath.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shortOBreath.setBackground(Color.yellow);
                if (!clientSyps1.contains("Shortness of breath or difficulty breathing")) {
                    clientSyps1.add("Shortness of breath or difficulty breathing");
                }
            }
        });
        fatigue.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fatigue.setBackground(Color.yellow);
                if (!clientSyps1.contains("Fatigue")) {
                    clientSyps1.add("Fatigue");
                }
            }
        });
        muscOBodAche.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muscOBodAche.setBackground(Color.yellow);
                if (!clientSyps1.contains("Muscle or body aches")) {
                    clientSyps1.add("Muscle or body aches");
                }
            }
        });
        headache.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headache.setBackground(Color.yellow);
                if (!clientSyps1.contains("Headache")) {
                    clientSyps1.add("Headache");
                }
            }
        });
        lossTaste.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lossTaste.setBackground(Color.yellow);
                if (!clientSyps1.contains("New loss of taste")) {
                    clientSyps1.add("New loss of taste");
                }
            }
        });
        lossSmell.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lossSmell.setBackground(Color.yellow);
                if (!clientSyps1.contains("New loss of smell")) {
                    clientSyps1.add("New loss of smell");
                }
            }
        });
        soreThroat.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soreThroat.setBackground(Color.yellow);
                if (!clientSyps1.contains("Sore throat")) {
                    clientSyps1.add("Sore throat");
                }
            }
        });
        congestion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                congestion.setBackground(Color.yellow);
                if (!clientSyps1.contains("Congestion")) {
                    clientSyps1.add("Congestion");
                }
            }
        });
        runnyNose.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runnyNose.setBackground(Color.yellow);
                if (!clientSyps1.contains("Runny nose")) {
                    clientSyps1.add("Runny nose");
                }
            }
        });
        nausea.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nausea.setBackground(Color.yellow);
                if (!clientSyps1.contains("Nausea")) {
                    clientSyps1.add("Nausea");
                }
            }
        });
        vomiting.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vomiting.setBackground(Color.yellow);
                if (!clientSyps1.contains("Vomiting")) {
                    clientSyps1.add("Vomiting");
                }
            }
        });
        diarrhea.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diarrhea.setBackground(Color.yellow);
                if (!clientSyps1.contains("Diarrhea")) {
                    clientSyps1.add("Diarrhea");
                }
            }
        });
        // CLICK WHEN FINISHED action button
        finished.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // symptoms need to be added before the client wants to proceed
                if (clientSyps1.isEmpty() && haveSymptrue == false) {
                    mustHaveSymp = new JLabel("You must add at least one symptom before proceeding.");
                    mustHaveSymp.setForeground(Color.RED);
                    jPanel.add(mustHaveSymp);
                    jPanel.revalidate();
                    // jPanel.setVisible(true);
                    haveSymptrue = true;
                } else {
                    if (!clientSyps1.isEmpty()) {
                        // remove all of the button and labels from this previous window for new window
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
                        jPanel.remove(runnyNose);
                        jPanel.remove(nausea);
                        jPanel.remove(vomiting);
                        jPanel.remove(diarrhea);
                        jPanel.remove(whichSyps);
                        jPanel.remove(finished);
                        jPanel.remove(area5);
                        jPanel.remove(area6);
                        jPanel.remove(area7);
                        jPanel.remove(area8);
                        jPanel.remove(area9);
                        jPanel.remove(area10);

                        if (haveSymptrue) {
                            jPanel.remove(mustHaveSymp);
                        }

                        // Again, updating all of the removed components to move onto the next window
                        jPanel.revalidate();
                        jPanel.setVisible(false);
                        lastPage(clientSyps1);
                    }
                }
            }
        });
    }

    // This method designates the last page of the symptom checker
    private void lastPage(ArrayList<String> clientSyps2) {
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        currSyps = new JLabel("Below are the symptoms listed that you selected:");
        currSyps.setAlignmentX(CENTER_ALIGNMENT);
        currSyps.setAlignmentY(CENTER_ALIGNMENT);
        Font text3 = new Font(Font.SANS_SERIF, Font.BOLD, 17);
        currSyps.setFont(text3);
        jPanel.add(currSyps);
        jPanel.setVisible(true);
        Font txtfont = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        textArea.setFont(txtfont);
        jPanel.add(textArea);
        // creating space between components
        // need to create this as a new component so it does not repeatedly add on top
        // of itself
        Component area1 = Box.createRigidArea(new Dimension(0, 10));
        jPanel.add(area1);

        jFrame.setSize(500, 550);
        // clears after client added new symptoms so that the old ones are not repeated
        textArea.setText("");
        /*
         * for each loop to go through client symptom list and add each symptom they
         * have to the text area
         */
        for (String str : clientSyps2) {
            textArea.append(str + "\n");
        }
        // It is not necessary for our client to edit the array list in the text area
        textArea.setEditable(false);
        contactProvider1 = new JLabel("Now that you have selected these options", JLabel.CENTER);
        contactProvider2 = new JLabel("please contact your local healthcare provider", JLabel.CENTER);
        contactProvider3 = new JLabel("or physician to report your symptoms.", JLabel.CENTER);
        contactProvider1.setForeground(Color.RED);
        contactProvider2.setForeground(Color.RED);
        contactProvider3.setForeground(Color.RED);
        // centering all of the components
        contactProvider1.setAlignmentX(CENTER_ALIGNMENT);
        contactProvider1.setAlignmentY(CENTER_ALIGNMENT);
        contactProvider2.setAlignmentX(CENTER_ALIGNMENT);
        contactProvider2.setAlignmentY(CENTER_ALIGNMENT);
        contactProvider3.setAlignmentX(CENTER_ALIGNMENT);
        contactProvider3.setAlignmentY(CENTER_ALIGNMENT);
        jPanel.add(contactProvider1);
        jPanel.add(contactProvider2);
        jPanel.add(contactProvider3);
        Component area2 = Box.createRigidArea(new Dimension(0, 15));
        jPanel.add(area2);
        // go back button
        goBack = new JButton("Click here to add additional symptoms");
        goBack.setAlignmentX(CENTER_ALIGNMENT);
        goBack.setAlignmentY(CENTER_ALIGNMENT);
        jPanel.add(goBack);
        // exit application button
        end = new JButton("EXIT APPLICATION");
        end.setAlignmentX(CENTER_ALIGNMENT);
        end.setAlignmentY(CENTER_ALIGNMENT);
        end.setBackground(Color.BLACK);
        end.setForeground(Color.WHITE);
        Component area3 = Box.createRigidArea(new Dimension(0, 25));
        jPanel.add(area3);
        jPanel.add(end);
        Component area4 = Box.createRigidArea(new Dimension(0, 25));
        jPanel.add(area4);

        goBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // remove all of the components on the page in order to start again
                jPanel.remove(goBack);
                jPanel.remove(currSyps);
                jPanel.remove(textArea);
                jPanel.remove(contactProvider1);
                jPanel.remove(contactProvider2);
                jPanel.remove(contactProvider3);
                jPanel.remove(end);
                // remove the rigid areas so that we can add them back and they won't add
                // stacked on top of each other
                jPanel.remove(area1);
                jPanel.remove(area2);
                jPanel.remove(area3);
                jPanel.remove(area4);
                revalidate();
                // pass in the list so that a new symptom list can be made in addition to the
                // old symptoms
                symptomPopup(clientSyps2);
            }
        });

        // Button that exits the user out of the program
        end.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        symptomTracker newTracker = new symptomTracker();
        newTracker.firstButtonOperation();
    }
}
