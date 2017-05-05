package models.boats;

import contracts.BoatEngine;
import contracts.IRace;
import exceptions.ArgumentException;

public class PowerBoat extends MotorBoat {
    private BoatEngine engine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight,BoatEngine engine, BoatEngine secondEngine) throws ArgumentException {
        super(model, weight);
        this.engine= engine;
        this.secondEngine = secondEngine;
    }

    @Override
    public double getSpeed(IRace race) {
        return (this.engine.getOutput() + this.secondEngine.getOutput()) -
                super.getWeight() + (race.getOceanCurrentSpeed() / 5D);
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
