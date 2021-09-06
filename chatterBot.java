import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class chatterBot extends JFrame {
    private JTextArea chatArea = new JTextArea();
    private JTextField chatterBox = new JTextField();

    public chatterBot() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setTitle("Welcome to ChatBot! A Chatbot and user experience.");
        frame.add(chatArea);
        frame.add(chatterBox);

        // Setting default settings for text area
        chatArea.setSize(600, 700);
        chatArea.setLocation(6, 6);

        // Setting default settings for text field
        // https://stackoverflow.com/questions/18908902/set-cursor-on-a-jtextfield -
        // allows for the cursor to be set automatically
        chatterBox.requestFocus();
        chatterBox.setSize(600, 40);
        chatterBox.setLocation(2, 0);

        chatterBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getTxt = chatterBox.getText();
                // We need to make sure that the text area is not empty, they will be prompted
                // to type a message to the Chatter Bot or exit the dialogue box.
                if (getTxt.isEmpty()) {
                    chatArea.append(
                            "Please type a message to send the Chatter Bot or type EXIT to exit out of the program."
                                    + "\n");
                } 
                //This command will implement the EXIT window command if the user types EXIT in any manner (lower or uppercase)
                if (getTxt.toUpperCase() == "EXIT" || getTxt.toUpperCase() == ("EXIT")) {
                    //this command will close the window that the user no longer wants
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
                //this allows for the back and forth with the users cursor being specified for whos text was whos
                chatArea.append("Me >> " + getTxt + "\n");

                if (getTxt.contains("hello")) {
                    chatArea.append("Chatter Bot >>> Hello Friend!" + "\n");
                }
                chatterBox.setText("");
                // chatArea.append("Chatter Bot >>>" + getTxt + "\n");

            }
        });
    }

    public static void main(String args[]) {
        new chatterBot();
    }
}