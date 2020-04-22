package weinfeld.projectile;

import java.util.ArrayList;
import java.util.Random;

public class ProjectileMath {

    public static final int NUM_PROJECTILES = 5;

    public static void main(String[] args) {

        ArrayList<Projectile> projectiles = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < NUM_PROJECTILES; i++) {
            projectiles.add(new Projectile(rand.nextDouble() * 180, rand.nextDouble() * 100));

        }

        for (Projectile projectile : projectiles) {
            for (int j = 0; j < 12; j++) {
                System.out.println(projectile);
                projectile.increaseTime(1);
            }
            System.out.println();
        }
    }
}
