import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import java.util.Random;

public class RegistrationForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Parola:");
        passwordField = new JPasswordField(4);
        JLabel confirmPasswordLabel = new JLabel("Confirmati Parola:");
        confirmPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Inregistrare");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                if (username.isEmpty() || password.length == 0 || confirmPassword.length == 0) {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Va rugam sa completati toate campurile!");
                } else if (!new String(password).equals(new String(confirmPassword))) {
                    JOptionPane.showMessageDialog(RegistrationForm.this, "Parolele nu corespund!");
                } else {
                                        
                    int raspuns = JOptionPane.showOptionDialog(new JFrame (), "Inregistrarea a fost facuta cu succes!", "Inregistrare", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Ok"}, JOptionPane.YES_OPTION);
                    if(raspuns == JOptionPane.YES_OPTION){
                        Login login = new Login();
                setVisible(false);
                login.setVisible(true);
                login.setSize(1920, 1080);
                    }
                    usernameField.setText("");
                    passwordField.setText("");
                    confirmPasswordField.setText("");
                }
               
            
            }
        });

        
                
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(registerButton);

        setContentPane(panel);
        
        
         try(PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\alexa\\OneDrive\\Documents\\NetBeansProjects\\Proiect.2\\Inregistrare.txt",true))) {
//            File file = new File("Inregistrare.txt");
String name1 = usernameField.getText();
        String psd = String.valueOf(passwordField.getPassword());
//            FileWriter writer = new FileWriter(file);
            writer.write(name1.trim()+","+psd.trim());
//            writer.newLine();
            writer.close();
//            System.out.println("Informatiile au fost salvate cu succes in fisierul text.");
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("A aparut o eroare la salvarea informatiilor in fisierul text: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegistrationForm registrationForm = new RegistrationForm();
                registrationForm.setVisible(true);
                
            }
        });

    }
    
} 
