package models.attackers;

import models.targets.Target;

public interface Attacker {
    void attack();
    void setTarget(Target target);
}
