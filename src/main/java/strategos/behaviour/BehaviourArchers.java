package strategos.behaviour;


import strategos.util.Config;
import strategos.model.GameState;
import strategos.units.Unit;

import java.util.logging.Logger;


/**
 * @author Devon Mortimer
 * Code reviewer: Brandon Scott-Hill
 */
class BehaviourArchers extends UnitBehaviour {

    private static Logger logger = Logger.getLogger("strategos.behaviour");

    BehaviourArchers(GameState gameState) {
        super(gameState);
    }

    private BehaviourArchers(BehaviourArchers behaviourArchers, GameState newState) {
        super(behaviourArchers, newState);
    }

    @Override public int getStrength(Unit unit) {
        return Config.ARCHERS_STRENGTH;
    }

    @Override public int getToughness(Unit unit) {
        return Config.ARCHERS_TOUGHNESS;
    }

    @Override public Behaviour copy(GameState newState) {
        return new BehaviourArchers(this, newState);
    }

    @Override public void charge(Unit unit) {
        // Archers cannot charge, so this blank method overrides the default
        // behaviour
    }

    @Override public int attack(Unit unit, Unit enemy) {
        logger.info(String.format("%s: range attack %s", this.getClass(), enemy));

        if (enemy == null) {
            throw new NullPointerException("Method attack() requires a non-null enemy");
        }

        if (!isAlive(unit) || !enemy.isAlive()) {
            logger.info(String.format("%s: cannot attack", this.getClass()));
            return 0;
        }

        if (getActionPoints(unit) <= 0) {
            logger.info(String.format("%s: not enough action points to attack", this.getClass()));
            return 0;
        }

        setActionPoints(getActionPoints(unit) - 1);
        enemy.defend(unit);

        return 0;
    }

    @Override public int getAttackRange() {
        return Config.ARCHER_RANGE;
    }

    @Override public String toString() {
        return "BehaviourArchers{} " + super.toString();
    }
}
