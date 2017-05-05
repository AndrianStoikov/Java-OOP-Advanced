package models.boats;


import Utility.Constants;
import contracts.IRace;
import exceptions.ArgumentException;

public class SailBoat extends MotorBoat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }


    private void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if(sailEfficiency < 1 || sailEfficiency > 100)
            throw new ArgumentException(Constants.IncorrectSailEfficiencyMessage);
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public boolean isMotorBoat() {
        return false;
    }

    @Override
    public double getSpeed(IRace race) {
        return (race.getWindSpeed() * (this.sailEfficiency / 100.0)) - this.getWeight() + (race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
