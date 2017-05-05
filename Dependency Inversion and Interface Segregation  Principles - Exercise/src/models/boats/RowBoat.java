package models.boats;

import Utility.Validator;
import contracts.IRace;
import exceptions.ArgumentException;

public class RowBoat extends MotorBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) throws ArgumentException {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public boolean isMotorBoat() {
        return false;
    }

    @Override
    public double getSpeed(IRace race) {
        return (this.oars * 100.0) - this.getWeight() + race.getOceanCurrentSpeed();
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }


}
