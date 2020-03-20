package weinfeld.Shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {

    private ShapeComponent shapesComponent;
    private JButton cupcakeButton;
    private JButton lightButton;
    private JButton smileButton;
    private JButton penguinButton;
    private JPanel leftPanel;

    public ShapesFrame() {

        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "SHAPES");

        setLayout(new BorderLayout());
        shapesComponent = new ShapeComponent();
        add(shapesComponent, BorderLayout.CENTER);
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        cupcakeButton = new JButton("Cupcake");
        cupcakeButton.addActionListener(actionEvent -> shapesComponent.setShapeCupcake());
        lightButton = new JButton("Light Bulb");
        lightButton.addActionListener(actionEvent -> shapesComponent.setShapeLightBulb());
        smileButton = new JButton("Smiley");
        smileButton.addActionListener(actionEvent -> shapesComponent.setShapeSmile());
        penguinButton = new JButton("Penguin");
        penguinButton.addActionListener(actionEvent -> shapesComponent.setShapePenguin());
        leftPanel.add(cupcakeButton);
        leftPanel.add(lightButton);
        leftPanel.add(smileButton);
        leftPanel.add(penguinButton);

        add(leftPanel, BorderLayout.WEST);

    }

    public static void main(String[] args) {

        new ShapesFrame().setVisible(true);
    }

}
