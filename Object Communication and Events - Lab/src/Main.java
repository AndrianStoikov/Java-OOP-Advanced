import commands.*;
import commands.group.GroupAttackCommand;
import commands.group.GroupTargetCommand;
import groups.AttackGroup;
import groups.Group;
import logger.*;
import models.attackers.Warrior;
import models.targets.Dragon;
import models.targets.Target;
import writers.ConsoleWriter;
import writers.Writer;

public class Main {
    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        Handler combatLogger = new CombatLogger(writer);
        Handler eventLogger = new EventLogger(writer);

        combatLogger.setSuccessor(eventLogger);

        combatLogger.handle(LogType.EVENT, "some event");
        combatLogger.handle(LogType.ATTACK, "attackkiiiing :)");


        AttackGroup group = new Group();
        group.addMember( new Warrior("TGonyBoy", 14, combatLogger));
        group.addMember(new Warrior("Warisan", 2, combatLogger));

        Target dragon = new Dragon("Sindra", 10, 1000, combatLogger);

        Executor executor = new CommandExecutor();
        Command targetCommand = new GroupTargetCommand(group, dragon);
        Command attackCommand = new GroupAttackCommand(group);
        executor.executeCommand(targetCommand);
        executor.executeCommand(attackCommand);
    }
}
