package weinfeld.projectile;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ProjectileFrame extends JFrame {

    private JTextArea projectileCoordinates;
    private JTextField velocity;
    private JTextField angle;
    private JButton calculateButton;
    private JLabel velocityLabel;
    private JLabel angleLabel;

    private JPanel leftPanel;
    public ProjectileFrame() {
        setSize(300, 400);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        projectileCoordinates = new JTextArea();
        velocity = new JTextField();
        angle = new JTextField();
        calculateButton = new JButton("Calculate");
        velocityLabel =  new JLabel("Velocity");
        angleLabel = new JLabel("Angle (degrees)");

        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 2));
        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);


        add(projectileCoordinates, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        calculateButton.addActionListener(actionEvent -> calculate());
    }

    public void calculate() {
        double a = Double.parseDouble(angle.getText());
        double v = Double.parseDouble(velocity.getText());
        Projectile projectile = new Projectile(a,v);
        String[] coordinates = new String[31];
        for (int j = 0; j < 31; j++) {
            coordinates[j] = projectile.toString() + "\n";
            projectile.increaseTime(1);
        }
        projectileCoordinates.setText(String.join("", coordinates));

    }

    public static void main(String[] args) {
        new ProjectileFrame().setVisible(true);
    }

}
