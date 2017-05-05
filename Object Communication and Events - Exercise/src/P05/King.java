package P05;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class King {

    private String name;

    private Map<String, Soldier> guards;
    private Map<String, Soldier> footmen;

    public King(String name) {
        this.name = name;
        this.guards = new LinkedHashMap<>();
        this.footmen = new LinkedHashMap<>();
    }

    public void addGuard(Soldier guard) {
        guard.setKing(this);
        this.guards.put(guard.getName(), guard);
    }

    public void addFootman(Soldier footman) {
        footman.setKing(this);
        this.footmen.put(footman.getName(), footman);
    }

    public void getSoldierAttacked(String name) {
        if (this.guards.get(name) == null) {
            this.footmen.get(name).takeDamage();
        } else {
            this.guards.get(name).takeDamage();
        }
    }

    public void respondToSoldierDeath(String name) {
        if (this.guards.remove(name) == null) {
            this.footmen.remove(name);
        }
    }

    public void getAttacked() {
        System.out.printf("King %s is under attack!%n", this.name);
        this.guards.values().forEach(Soldier::respondToAttack);
        this.footmen.values().forEach(Soldier::respondToAttack);
    }
}
