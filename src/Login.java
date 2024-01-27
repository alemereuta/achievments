import java.util.Arrays;
 import java.awt.FlowLayout;
 import javax.swing.*;
 import java.awt.event.*;

 public class Login extends JFrame implements ActionListener{
   private JLabel userLabel, passwordLabel, validateLabel;
   private JTextField userText;
   private JPasswordField password;
   private ImageIcon valid, invalid;
   private JButton logButton;
   private String username = "Gamer200";
   private char[] correctPassword = { 'p', 'a', 'r', 'o', 'l', 'a',};
 	
   public Login(){
 	super("Login Validation");
 	setLayout(new FlowLayout());
 	userLabel = new JLabel("Username: ");
 	passwordLabel = new JLabel("Password: ");
 	validateLabel = new JLabel();
 	userText = new JTextField(15);
 	password = new JPasswordField(15);
 	valid = new ImageIcon("tick32.png"); 	invalid = new ImageIcon("cross32.png");
 	logButton = new JButton("Login");
 	logButton.addActionListener(this);
 	add(userLabel);
 	add(userText);
 	add(passwordLabel);
 	add(password);
 	add(logButton);
 	add(validateLabel);
   }
 	
   public void actionPerformed(ActionEvent e){
 	String usr = userText.getText();
 	char[] input = password.getPassword();
        
 		
 	if (usr.equals("Gamer200")) {
 	  if (Arrays.equals(input, correctPassword)) {
 	     validateLabel.setText("Conectare facuta cu succes!");
 	     validateLabel.setIcon(valid);
             Meniu mn = new Meniu();
             mn.setVisible(true);
             setVisible(false);
 	  }
 	  else {
 	     validateLabel.setText("Ne pare rau, parola este incorecta.");
 	     validateLabel.setIcon(invalid);
 	  }
 	}
 	else {
 	  validateLabel.setText("Ne pare rau, username-ul nu exista.");
 	  validateLabel.setIcon(invalid);
 	}
   }
  	public static void main(String args[]){
 	Login window = new Login();
 	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	window.setSize(300, 180);
 	window.setVisible(true);
   }
 }