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

    @Test
    public void getY() {

        //given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        //when
        double y = projectile.getY();

        //then
        assertEquals(83.5568, y, 0.0001);
    }

    @Test
    public void increaseTime() {

        //given
        Projectile projectile = new Projectile(53.26, 82);

        //when
        projectile.increaseTime(5);

        //then
        assertEquals(245.2557, projectile.getX(), 0.0001);
        assertEquals(83.5568, projectile.getY(), 0.0001);
    }

}