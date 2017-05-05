package models.engines;

import Utility.Constants;
import Utility.Validator;
import contracts.BoatEngine;
import contracts.IModelable;
import exceptions.ArgumentException;

public class JetEngine implements IModelable, BoatEngine {
    private static final int Multiplier = 5;
    private int cachedOutput;
    private String model;
    private int horsepower;
    private int displacement;

    public JetEngine(String model, int horsepower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) throws ArgumentException {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    @Override
    public int getOutput() {
        this.cachedOutput = (this.horsepower * Multiplier) + this.displacement;
        return this.cachedOutput;
    }

    private void setHorsepower(int horsepower) throws ArgumentException {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
