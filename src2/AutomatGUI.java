import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatGUI extends JFrame {
    private JPanel automatPanel;

    public AutomatGUI() {
        setTitle("Automat Finit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Crearea panoului pentru reprezentarea automatului
        automatPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Aici puteți desena stările și tranzitiile automatului
                // Pentru exemplul de bază, vom desena doar trei stări
                g.setColor(Color.black);
                g.drawOval(100, 100, 50, 50);
                g.drawOval(250, 100, 50, 50);
                g.drawOval(175, 250, 50, 50);
                // Desenați săgețile pentru tranzitii
                g.drawLine(125, 125, 225, 125);
                g.drawLine(275, 125, 200, 250);
                g.drawLine(225, 150, 200, 250);
            }
        };

        // Adăugarea panoului de reprezentare grafică la fereastra principală
        add(automatPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AutomatGUI automatGUI = new AutomatGUI();
            automatGUI.setVisible(true);
        });
    }
}