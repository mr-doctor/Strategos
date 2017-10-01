package strategos.behaviour;


import org.junit.*;
import strategos.*;
import strategos.units.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class BehaviourArchersTest {

    private Behaviour behaviour;
    private Unit      unit;

    @Before public void setUp() throws Exception {
        BehaviourFactory behaviourFactory = new BehaviourFactoryImpl();
        behaviour =
                behaviourFactory.createBehaviourArchers(TestUtil.getMockGameState());
        unit = TestUtil.getMockUnit();
    }

    @Test public void getStrength() throws Exception {
        assertThat(
                "Archer strength should be same as in Config",
                behaviour.getStrength(unit),
                is(Config.ARCHERS_STRENGTH)
        );
    }

    @Test public void getToughness() throws Exception {
        assertThat(
                "Archer toughness should be same as in Config",
                behaviour.getToughness(unit),
                is(Config.ARCHERS_TOUGHNESS)
        );
    }

    @Test public void charge() throws Exception {
        assertFalse(true);
    }

    @Test public void attack() throws Exception {
        assertFalse(true);
    }

    @Test public void getActionPoints() throws Exception {
        behaviour.turnTick(unit);
        assertThat(
                "Archer action points should be same as in Config",
                behaviour.getActionPoints(unit),
                is(Config.INFANTRY_ACTION_POINTS)
        );
    }
}