package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    public static final int TARGET_XP = 10;

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };
        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Hero hero = new Hero("testHero", fakeWeapon);

        hero.attack(fakeTarget);
        assertEquals(TARGET_XP,fakeTarget.giveExperience());
    }
}