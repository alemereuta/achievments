import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Meniu extends JFrame {
    public Meniu() {
        setTitle("Meniu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setLayout(null);
        

        JButton openWindow1Button = new JButton("Chestionare");
        openWindow1Button.setBounds(480, 180, 600, 200);
        openWindow1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Window1 window1 = new Window1();
                window1.setVisible(true);
            }
        });

        JButton openWindow2Button = new JButton("Legislatie");
        openWindow2Button.setBounds(480, 400, 600, 200);
        openWindow2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Legislatie window2 = new Legislatie();
                window2.setVisible(true);
            }
        });
        
        

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(openWindow1Button);
        panel.add(openWindow2Button);

       add(openWindow1Button);
       add(openWindow2Button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Meniu meniu = new Meniu();
                meniu.setVisible(true);
            }
        });
    }
}

class Window1 extends JFrame {
    public Window1() {
        setTitle("Chestionare");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setLayout(null);
        JButton catA = new JButton("Categoria A");
        JButton catB = new JButton("Categoria B");
        JButton catC = new JButton("Categoria C");
        JButton catD = new JButton("Categoria D");
        JButton catTr = new JButton("Categoria Tr");
        
        add(catA);
        add(catB);
        add(catC);
        add(catD);
        add(catTr);
        
       catA.setBounds(650,20,200,100);
       catB.setBounds(650,180,200,100);
       catC.setBounds(650,340,200,100);
       catD.setBounds(650,500,200,100);
       catTr.setBounds(650,660,200,100);
       
       catA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChestionareA A = new ChestionareA();
                setVisible(false);
                A.setVisible(true);
                A.setSize(1920, 1080);
            }
        });
       
       catB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChestionareB B = new ChestionareB();
                setVisible(false);
                B.setVisible(true);
                B.setSize(1920, 1080);
            }
        });
       
       catC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChestionareC C = new ChestionareC();
                setVisible(false);
                C.setVisible(true);
                C.setSize(1920, 1080);
            }
        });
       
       catD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChestionareD D = new ChestionareD();
                setVisible(false);
                D.setVisible(true);
                D.setSize(1920, 1080);
            }
        });
       
       catTr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChestionareTr Tr = new ChestionareTr();
                setVisible(false);
                Tr.setVisible(true);
                Tr.setSize(1920, 1080);
            }
        });
    }
}

class Window2 extends JFrame {
    public Window2() {
        setTitle("Legislatie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1920, 1020);
        setLocationRelativeTo(null);
    }
}
