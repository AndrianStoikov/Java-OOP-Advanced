package models.attackers;

import logger.Handler;
import logger.LogType;
import logger.Logger;
import models.targets.Target;
import observers.Observer;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getLogger().handle(LogType.EVENT, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }

    @Override
    public void update(int value) {

    }
}
