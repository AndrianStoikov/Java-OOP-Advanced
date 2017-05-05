package app.factories;

import app.models.BurnableGarbage;
import app.models.RecyclableGarbage;
import app.models.StorableGarbage;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class WasteFactory {

    private static final String BURNABLE = "Burnable";
    private static final String RECYCLABLE = "Recyclable";
    private static final String STORABLE = "Storable";

    public static Waste create(String type, String name, double weight, double volumePerKg) {
        switch (type) {
            case BURNABLE:
                return new BurnableGarbage(name, volumePerKg, weight);
            case RECYCLABLE:
                return new RecyclableGarbage(name, volumePerKg, weight);
            case STORABLE:
                return new StorableGarbage(name, volumePerKg, weight);
        }
        return null;
    }
}
