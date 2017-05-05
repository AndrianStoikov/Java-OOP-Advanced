package app.models;

import app.annotations.Storable;

@Storable
public class StorableGarbage extends BaseGarbage {

    public StorableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
