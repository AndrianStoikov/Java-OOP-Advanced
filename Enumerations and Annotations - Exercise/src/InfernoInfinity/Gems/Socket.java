package InfernoInfinity.Gems;

public enum Socket {

    RUBY(7, 2, 5), EMERALD(1, 4, 9), AMETHYST(2, 8, 4);

    private int agility;
    private int strength;
    private int vitality;

    Socket(int strength, int agility, int vitality) {
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getVitality() {
        return this.vitality;
    }

    public int getMinDamageIncrease() {
        return (2 * this.strength) + this.agility;
    }

    public int getMaxDamageIncrease() {
        return (3 * this.strength) + (4 * this.agility);
    }
}
