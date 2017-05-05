package BlobProblem.models.factories;

import BlobProblem.interfaces.Attack;
import BlobProblem.interfaces.Behaviour;
import BlobProblem.models.Blob;

import java.lang.reflect.InvocationTargetException;

public class BlobFactory {
    public static Blob createBlob(String name, int health, int damage, String behavior, String attackName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Behaviour behaviour = BehaviorFactory.createBehaviour(behavior);
        Attack attack = AttackFactory.createAttack(attackName);
        return new Blob( name,  health,  damage, behaviour, attack);
    }
}
