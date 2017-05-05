package BlobProblem.models.factories;

import BlobProblem.interfaces.Behaviour;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BehaviorFactory {

    private static final String BEHAVIOURS_PATH = "BlobProblem.models.behaviours.";

    public static Behaviour createBehaviour(String behavior) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        behavior = Character.toUpperCase(behavior.charAt(0)) + behavior.substring(1);
        Class<?> behaviourClass = Class.forName(BEHAVIOURS_PATH + behavior + "Behavior");
        Constructor<?> behaviourConstructor = behaviourClass.getConstructor();
        return (Behaviour) behaviourConstructor.newInstance();
    }
}
