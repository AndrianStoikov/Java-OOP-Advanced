package app.strategies;

import app.waste_disposal.DefaultProcessingData;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class StrategyStorable implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double total = garbage.getWeight() * garbage.getVolumePerKg();
        double energyProduced = 0;
        double energyUsed = total * 0.13;
        double capitalEarned = 0;
        double capitalUsed = total * 0.65;
        return new DefaultProcessingData(energyProduced - energyUsed, capitalEarned - capitalUsed);
    }
}
