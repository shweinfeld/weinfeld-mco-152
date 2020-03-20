package weinfeld.Shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    private String shape = "";
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int centerX = width/2;
        int centerY = height/2;
        g.translate(centerX, centerY);


        switch (shape) {
            case "Penguin":
                drawPenguin(g);
                break;
            case "Smile":
                drawSmile(g);
                break;
            case "Light":
                drawLightBulb(g);
                break;
            case "Cupcake":
                drawCupcake(g);
                break;
            default:
                ;
                break;
        }

    }

    private void drawCupcake(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(-20, -85, 40, 40);
        g.setColor(Color.pink);
        g.fillOval(-70, -65, 140, 100);
        g.fillOval(-85, -15, 170, 52);
        g.setColor(Color.orange);
        int[] xpoints = {-50, -70, 70, 50, -50};
        int[] ypoints = {85, 25, 25, 85, 85};
        int npoints = 5;
        g.fillPolygon(xpoints, ypoints, npoints);

    }

    private void drawLightBulb(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(-60, -99, 120, 120);
        g.fillRect(-30, 2, 60, 50);
        g.setColor(Color.gray);
        g.fillRect(-30, 60, 60, 7);
        g.fillRect(-30, 73, 60, 7);
        int[] xpoints = {-15, -25, 25, 15, -15};
        int[] ypoints = {100, 86, 86, 100, 100};
        int npoints = 5;
        g.fillPolygon(xpoints, ypoints, npoints);
    }

    private void drawSmile(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(-80, -80, 160, 160);
        g.setColor(Color.black);
        g.fillOval(-60, -50, 120, 120);
        g.setColor(Color.yellow);
        g.fillRect(-60, -50, 120, 60);
        g.setColor(Color.black);
        g.drawArc(-50, -30, 40, 35, 0, 180);
        g.drawArc(10, -30, 40, 35, 0, 180);
    }

    private void drawPenguin(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(-70, -100, 140, 195);
        g.setColor(Color.orange);
        int[] xpoints1 = {-45, -5, -25, -45};
        int[] ypoints1 = {100, 100, 80, 100};
        int npoints = 4;
        g.fillPolygon(xpoints1, ypoints1, npoints);
        int[] xpoints2 = {45, 5, 25, 45};
        int[] ypoints2 = {100, 100, 80, 100};
        g.fillPolygon(xpoints2, ypoints2, npoints);
        g.setColor(Color.white);
        g.fillOval(-60, -30, 120, 120);
        g.setColor(Color.BLACK);
        g.fillOval(-80, -30, 45, 110);
        g.fillOval(35, -30, 45, 110);
        g.setColor(Color.white);
        g.fillOval(-30, -70, 25, 35);
        g.fillOval(5, -70, 25, 35);
        g.setColor(Color.blue);
        g.fillOval(-20, -60, 15, 17);
        g.fillOval(5, -60, 15, 17);

        g.setColor(Color.orange);
        int[] xpoints = {0, -10, 10, 0};
        int[] ypoints = {-13, -30, -30, -13};

        g.fillPolygon(xpoints, ypoints, npoints);

    }

    private void drawFourPointedStar(Graphics g) {
        int[] xpoints = {0,
                10,
                40,
                10,
                0,
                -10,
                -40,
                -10,
                0};
        int[] ypoints = {-40,
                -10,
                0,
                10,
                40,
                10,
                0,
                -10,
                -40};
        int npoints = 9;
        g.fillPolygon(xpoints, ypoints, npoints);
    }

    void setShapePenguin() {
        shape = "Penguin";
        repaint();
    }
    void setShapeStar() {
        shape = "Star";
        repaint();
    }
    void setShapeLightBulb() {
        shape = "Light";
        repaint();
    }
    void setShapeCupcake() {
        shape = "Cupcake";
        repaint();
    }

    void setShapeSmile() {
        shape = "Smile";
        repaint();
    }
}
