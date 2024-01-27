import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginSignUpWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login/Sign-Up Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        JPanel panel = new JPanel();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            
            System.out.println("Login button pressed");
            
        });

        JButton signUpButton = new JButton("Sign Up");
     
        panel.add(new JLabel("Welcome! Please choose an option:"));
        panel.add(loginButton);
        panel.add(signUpButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
        /*
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login lgn = new Login();
                frame.setVisible(false);
                lgn.setVisible(true);
                lgn.setSize(1920, 1080);
            }
                
    });*/
         loginButton.addActionListener(e -> {
            
            Login lgn = new Login();
                frame.setVisible(false);
                lgn.setVisible(true);
                lgn.setSize(1920, 1080);
            
        });
         signUpButton.addActionListener(e -> {
            
            RegistrationForm reg = new RegistrationForm();
                frame.setVisible(false);
                reg.setVisible(true);
                reg.setSize(1920, 1080);
            
        });
         
         
}
                }
