package commands.group;

import commands.Command;
import groups.AttackGroup;

public class GroupAttackCommand implements Command {
    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
