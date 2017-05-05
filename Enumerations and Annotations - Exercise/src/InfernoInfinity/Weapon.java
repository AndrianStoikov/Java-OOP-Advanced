package InfernoInfinity;

import InfernoInfinity.Annotations.Information;
import InfernoInfinity.Gems.Socket;

@Information(
        author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"}
)
public class Weapon implements IWeapon<Weapon>, Comparable<Weapon> {
    private Type type;
    private String name;
    private int minDamage;
    private int maxDamage;
    private Socket[] sockets;
    private int strength;
    private int agility;
    private int vitality;
    private double itemLevel;

    public Weapon(String type, String name) {
        this.setType(type);
        this.name = name;
        this.minDamage = this.type.getMinDamage();
        this.maxDamage = this.type.getMaxDamage();
        this.sockets = new Socket[this.type.getSockets()];
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    private void setType(String type) {
        this.type = Type.valueOf(type);
    }

    private boolean isInvalidIndex(int index) {
        return index >= this.sockets.length || index < 0;
    }

    private void calculateItemLevel() {
        this.itemLevel = ((double) (this.maxDamage + this.minDamage) / 2) + this.strength + this.agility + this.vitality;
    }

    @Override
    public void addGem(int index, Socket socket) {
        if (isInvalidIndex(index))
            return;

        if (this.sockets[index] != null) {
            this.removeGem(index);
        }

        this.sockets[index] = socket;
        this.minDamage += socket.getMinDamageIncrease();
        this.maxDamage += socket.getMaxDamageIncrease();
        this.strength += socket.getStrength();
        this.agility += socket.getAgility();
        this.vitality += socket.getVitality();
        this.calculateItemLevel();
    }

    @Override
    public void removeGem(int index) {
        if (isInvalidIndex(index))
            return;
        if (this.sockets[index] == null)
            return;

        Socket socket = this.sockets[index];
        this.sockets[index] = null;
        this.minDamage -= socket.getMinDamageIncrease();
        this.maxDamage -= socket.getMaxDamageIncrease();
        this.strength -= socket.getStrength();
        this.agility -= socket.getAgility();
        this.vitality -= socket.getVitality();
        this.calculateItemLevel();
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.minDamage, this.maxDamage,
                this.strength, this.agility, this.vitality);
    }

    public String toDetailedString() {
        return this.toString() + String.format(" (Item Level: %.1f)", this.itemLevel);
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.itemLevel, weapon.itemLevel);
    }
}
