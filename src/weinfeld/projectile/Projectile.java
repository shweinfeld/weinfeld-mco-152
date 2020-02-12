package weinfeld.projectile;

public class Projectile {

    public static final double EARTH_GRAVITY = 9.8;
    private final double angle;
    private final double velocity;
    private double time;


    public Projectile(double angleInDegrees, double velocity) {
        this.angle = Math.toRadians(angleInDegrees);
        this.velocity = velocity;
    }

    public double getX() {

        return velocity * Math.cos(angle) * time;
    }

    public double getY() {

        return velocity * Math.sin(angle) * time + (-EARTH_GRAVITY * time * time);
    }

    public void increaseTime(double timeChange) {
        time += timeChange;
    }

    @Override
    public String toString() {
        return time + " : (" + String.format("%.4f", getX()) + "," + String.format("%.4f", getY()) + ")";
    }
}
