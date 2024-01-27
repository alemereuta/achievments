import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Signin() {
        setTitle("Sign In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton signInButton = new JButton("Sign In");

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Perform sign-in logic here, such as checking username and password
                // Replace the code below with your actual sign-in logic

                if (username.equals("admin") && new String(password).equals("password")) {
                    JOptionPane.showMessageDialog(Signin.this, "Sign-in successful");
                } else {
                    JOptionPane.showMessageDialog(Signin.this, "Invalid username or password");
                }

                // Clear the fields after sign-in attempt
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(signInButton);

        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Signin signInForm = new Signin();
                signInForm.setVisible(true);
            }
        });
    }
}
