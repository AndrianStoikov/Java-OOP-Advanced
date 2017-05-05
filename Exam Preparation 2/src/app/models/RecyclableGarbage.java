package app.models;

import app.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends BaseGarbage {

    public RecyclableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
