package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.IModelable;
import contracts.Speedable;
import contracts.Typeable;
import exceptions.ArgumentException;

public abstract class MotorBoat implements IModelable, Speedable, Typeable {
    private String model;
    private int weight;

    public MotorBoat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setModel(String model) throws ArgumentException {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    private void setWeight(int weight) throws ArgumentException {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    protected int getWeight() {
        return weight;
    }

    @Override
    public String getModel() {
        return model;
    }

    public abstract boolean isMotorBoat();
}


