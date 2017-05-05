package models.boats;

import Utility.Validator;
import contracts.BoatEngine;
import contracts.IRace;
import exceptions.ArgumentException;

public class Yacht extends MotorBoat {
    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) throws ArgumentException {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) throws ArgumentException {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }

    @Override
    public double getSpeed(IRace race) {
        return this.engine.getOutput() - (this.getWeight() + this.cargoWeight) + ((double)race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
