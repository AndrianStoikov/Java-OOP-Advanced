package BlobProblem.models.factories;


import BlobProblem.interfaces.Attack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AttackFactory {

    private static final String ATTACKS_PATH = "BlobProblem.models.attacks.";

    public static Attack createAttack(String attackName) throws NoSuchMethodException, ClassNotFoundException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        attackName = Character.toUpperCase(attackName.charAt(0)) + attackName.substring(1);
        Class<?> attackClass = Class.forName( ATTACKS_PATH + attackName + "Attack");
        Constructor<?> behaviourConstructor = attackClass.getConstructor();
        return (Attack) behaviourConstructor.newInstance();
    }
}
