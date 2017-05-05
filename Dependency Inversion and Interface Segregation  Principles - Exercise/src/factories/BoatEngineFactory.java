package factories;

import Utility.Constants;
import contracts.BoatEngine;
import exceptions.ArgumentException;
import exceptions.NonExistantModelException;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BoatEngineFactory {

    public static BoatEngine createEngine(String model, int horsePower, int displacement, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NonExistantModelException, ArgumentException {
        type = type.toUpperCase();
        switch (type) {
            case "JET": {
                return new JetEngine(model, horsePower, displacement);
            }
            case "STERNDRIVE": {
                return new SterndriveEngine(model, horsePower, displacement);
            }
            default:
                throw new NonExistantModelException(Constants.IncorrectEngineTypeMessage);
        }
    }

}
