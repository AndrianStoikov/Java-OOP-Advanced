package app.models;

import app.annotations.Burnable;

@Burnable
public class BurnableGarbage extends BaseGarbage {
    public BurnableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
