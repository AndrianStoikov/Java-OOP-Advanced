package tests.fakes;

import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 22.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class NonDisposableWaste implements Waste {
    private String name;
    private double volumePerKg;
    private double weight;

    public NonDisposableWaste() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

}
