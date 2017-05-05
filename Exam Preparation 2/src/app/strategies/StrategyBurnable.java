package app.strategies;

import app.waste_disposal.DefaultProcessingData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class StrategyBurnable implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double total = garbage.getWeight() * garbage.getVolumePerKg();
        double energyProduced = total;
        double energyUsed = total * 0.2;
        double capitalEarned = 0;
        double capitalUsed = 0;
        return new DefaultProcessingData(energyProduced - energyUsed, capitalEarned - capitalUsed);
    }
}
