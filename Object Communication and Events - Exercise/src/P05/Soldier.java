package P05;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface Soldier {

    String getName();

    void takeDamage();

    void respondToAttack();

    void setKing(King king);
}
