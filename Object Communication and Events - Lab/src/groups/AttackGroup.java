package groups;

import models.attackers.Attacker;
import models.targets.Target;

public interface AttackGroup {
    void addMember(Attacker attacker);

    void groupTarget(Target target);

    void groupAttack();
}
