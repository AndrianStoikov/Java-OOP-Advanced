package app.waste_disposal;

import app.waste_disposal.contracts.ProcessingData;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DefaultProcessingData implements ProcessingData {
    private double energy;
    private double capital;

    public DefaultProcessingData(double energy, double capital) {
        this.energy = energy;
        this.capital = capital;
    }

    @Override
    public double getEnergyBalance() {
        return this.energy;
    }

    @Override
    public double getCapitalBalance() {
        return this.capital;
    }
}
