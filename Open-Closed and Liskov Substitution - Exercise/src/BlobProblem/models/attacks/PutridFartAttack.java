package BlobProblem.models.attacks;

import BlobProblem.interfaces.Attack;
import BlobProblem.models.Blob;

import java.lang.reflect.Field;

public class PutridFartAttack implements Attack {

    @Override
    public void attack(Blob attacker, Blob toAttack) throws NoSuchFieldException, IllegalAccessException {
        Field damageField = attacker.getClass().getDeclaredField("currentDamage");
        int damage = (int) damageField.get(attacker);
    }
}
