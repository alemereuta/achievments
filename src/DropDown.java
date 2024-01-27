
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropDown {
   public static void main(String[] args){
       String[] optionsToChoose = {"Administrator", "Cursant"};
       
       JFrame jFrame = new JFrame();
       
       JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
       jComboBox.setBounds(80, 50, 140, 20);
       
       JButton jButton = new JButton("Done");
       jButton.setBounds(100, 100, 90, 20);
       
       JLabel jLabel = new JLabel();
       jLabel.setBounds(90, 100, 400, 100);
       
       jFrame.add(jButton);
       jFrame.add(jComboBox);
       jFrame.add(jLabel);
       
       jFrame.setLayout(null);
       jFrame.setSize(350, 250);
       jFrame.setVisible(true);
       
       jButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           if(jComboBox.getSelectedIndex()==0)
           {
                Meniu men = new Meniu();
                jFrame.setVisible(false);
                men.setVisible(true);     
           }
           else{
               RegistrationForm rf = new RegistrationForm();
               jFrame.setVisible(false);
               rf.setVisible(true);
           }
       }
       
   });
       String valoareSelectata = jComboBox.getSelectedItem().toString();
       
       JButton redirectionare = new JButton();
       
       
       }
    
   } 

