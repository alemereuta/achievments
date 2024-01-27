
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JTextArea;


public class Legislatie extends JFrame {
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner user_input = new Scanner(System.in);
        JFrame window = new JFrame("Legislatie");
        String all = "";
        Scanner scanner = new Scanner(new File("C:/Users/alexa/OneDrive/Documents/NetBeansProjects/Proiect.2/Legislatie.txt"));
        
        JButton backButton = new JButton("Inapoi");
         
                
        if(scanner.hasNext()){
            all = scanner.useDelimiter("\\A").next();
            if(all.isEmpty()){
                System.out.println("Fisierul este gol.");
            }
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            final JTextArea textArea = new JTextArea(10, 20);
            JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            textArea.setText(all);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            window.add(scroll);
            window.setSize(500, 500);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
//            window.add(backButton);
             window.add(backButton,BorderLayout.SOUTH);
             textArea.setEditable(false);
    
        }
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Meniu men = new Meniu();
                window.setVisible(false);
                men.setVisible(true);
            }
        });
    }

    
}

