package Tests;

import org.junit.Before;
import org.junit.Test;
import wireworld.Game;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void setRun() { // And IsRun()
        game.setRun(true);
        assertTrue(game.isRun());
        game.setRun(false);
        assertFalse(game.isRun());
        game.setRun(true);
        assertTrue(game.isRun());
    }
}