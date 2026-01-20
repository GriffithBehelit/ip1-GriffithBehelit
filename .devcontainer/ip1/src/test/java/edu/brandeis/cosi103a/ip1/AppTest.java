package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class AppTest {

    @Test
    public void testRollDieRange() {
        Random rng = new Random(42);

        for (int i = 0; i < 100; i++) {
            int roll = App.rollDie(rng);
            assertTrue("Roll should be between 1 and 6",
                       roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testRollDieDeterministicWithSeed() {
        Random rng1 = new Random(123);
        Random rng2 = new Random(123);

        assertEquals(App.rollDie(rng1), App.rollDie(rng2));
        assertEquals(App.rollDie(rng1), App.rollDie(rng2));
        assertEquals(App.rollDie(rng1), App.rollDie(rng2));
    }
}
