package P08;

import P08.Missions.Mission;
import P08.Repairs.Repair;
import P08.Soldiers.Privates.LeutenantGenerals.LeutenantGeneral;
import P08.Soldiers.Privates.Private;
import P08.Soldiers.Privates.SpecialisedSoldiers.Commando;
import P08.Soldiers.Privates.SpecialisedSoldiers.Engineer;
import P08.Soldiers.Soldier;
import P08.Soldiers.Spies.Spy;

import java.util.LinkedHashMap;
import java.util.Map;

public class Manager {
    Map<String, Private> privates;
    Map<String, Soldier> soldiers;

    public Manager() {
        this.privates = new LinkedHashMap<>();
        this.soldiers = new LinkedHashMap<>();
    }

    public void createPrivate(String id, String firstName, String lastName, Double salary) {
        Private soldier = new Private(id, firstName, lastName, salary);
        this.privates.put(id, soldier);
        this.soldiers.put(id, soldier);
    }

    public void createSpy(String id, String firstName, String lastName, Integer codeNumber) {
        Spy soldier = new Spy(id, firstName, lastName, codeNumber);
        this.soldiers.put(id, soldier);
    }

    public void createGeneral(String id, String firstName, String lastName, Double salary, String[] cmdArgs) {
        LeutenantGeneral general = new LeutenantGeneral(id, firstName, lastName, salary);
        this.addPrivatesToGeneral(general, cmdArgs);

        this.soldiers.put(id, general);
    }

    public void createEngineer(String id, String firstName, String lastName, Double salary,
                               String corps, String[] cmdArgs) {
        Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
        this.addPartsToEngineer(engineer, cmdArgs);
        this.soldiers.put(id, engineer);
    }

    public void createCommando(String id, String firstName, String lastName,
                               Double salary, String corps, String[] cmdArgs) throws IllegalArgumentException {

        Commando commando = new Commando(id, firstName, lastName, salary, corps);
        this.addMissionsToCommando(commando, cmdArgs);
        this.soldiers.put(id, commando);
    }

    public String printStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Soldier soldier : soldiers.values()) {
            sb.append(soldier.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    private void addMissionsToCommando(Commando commando, String[] cmdArgs) {
        for (int i = 6; i < cmdArgs.length; i += 2) {
            try {
                String name = cmdArgs[i];
                String state = cmdArgs[i + 1];
                Mission mission = new Mission(name, state);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {
                // nothing
            }
        }
    }

    private void addPartsToEngineer(Engineer engineer, String[] cmdArgs) {
        for (int i = 6; i < cmdArgs.length; i += 2) {
            String name = cmdArgs[i];
            int hours = Integer.parseInt(cmdArgs[i + 1]);
            Repair part = new Repair(name, hours);
            engineer.addPart(part);
        }
    }

    private void addPrivatesToGeneral(LeutenantGeneral general, String[] cmdArgs) {
        for (int i = 5; i < cmdArgs.length; i++) {
            general.addPrivate(this.privates.get(cmdArgs[i]));
        }
    }
}
