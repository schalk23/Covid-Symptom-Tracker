//To RUN this file -- java chatterBot.java OR use play button like you normally run but do java chatterBot.java not javac chatterBot.java

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
        frame.setSize(800,800);
        frame.setTitle("Welcome to ChatBot! A Chatbot and user experience.");
        frame.add(chatArea);
        frame.add(chatterBox);
        
        //Setting default settings for text area 
        chatArea.setSize(800,700);
        chatArea.setLocation(4,4);

        //Setting default settings for text field
        chatterBox.setSize(600,40);
        chatterBox.setLocation(2,0); 

        chatterBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getTxt = chatterBox.getText();
                chatArea.append("Me >> " + getTxt + "\n");
                chatterBox.setText("");
                //chatArea.append("Chatter Bot >>>" + getTxt + "\n");

                if(getTxt.contains("hello")) {
                    chatArea.append("Chatter Bot >>> Hello Friend!" + "\n");
                }
            }
        });
    }


    public static void main(String args[]) {
        new chatterBot();    
    }
}