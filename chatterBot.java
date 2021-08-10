import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        chatArea.setSize(800, 700);
        chatArea.setLocation(4, 4);

        // Setting default settings for text field
        chatterBox.setSize(600, 40);
        chatterBox.setLocation(2, 0);

        chatterBox.addActionListener(new ActionListener() {
            @Override
            //NOTE: The cursor must be in the middle of the text area, or else it will not register the text !!!!!!!!!!!!!!!!!!!!! run code
            public void actionPerformed(ActionEvent e) {
                String getTxt = chatterBox.getText();
                // We need to make sure that the text area is not empty, they will be prompted
                // to type a message to the Chatter Bot or exit the dialogue box.
                if (getTxt.isEmpty()) {
                    chatArea.append(
                            "Please type a message to send the Chatter Bot or type EXIT to exit out of the program."
                                    + "\n");
                    // if(getTxt.toUpperCase() == "EXIT" || getTxt.toUpperCase().contains("EXIT")) {
                    // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    
                }
                chatArea.append("Me >> " + getTxt + "\n");
                chatterBox.setText("");
                // chatArea.append("Chatter Bot >>>" + getTxt + "\n");

                if (getTxt.contains("hello")) {
                    chatArea.append("Chatter Bot >>> Hello Friend!" + "\n");
                }

            }
        });
    }

    public static void main(String args[]) {
        new chatterBot();
    }
}