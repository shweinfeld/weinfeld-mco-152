package weinfeld.projectile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectileTest {

    @Test
    public void getX() {

        // given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        // when
        double x = projectile.getX();

        // then
        assertEquals(245.2557, x, 0.0001);
    }

}