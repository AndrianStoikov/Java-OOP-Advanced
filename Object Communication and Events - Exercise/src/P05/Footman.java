package P05;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Footman implements Soldier {

    private static final int HP = 2;

    private String name;
    private King king;
    private int currentHP;

    public Footman(String name) {
        this.name = name;
        this.currentHP = HP;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void takeDamage() {
        this.currentHP -= 1;
        if (this.currentHP <= 0) {
            this.king.respondToSoldierDeath(this.name);
        }
    }

    @Override
    public void respondToAttack() {
        System.out.printf("Footman %s is panicking!%n", this.name);
    }

    @Override
    public void setKing(King king) {
        this.king = king;
    }
}