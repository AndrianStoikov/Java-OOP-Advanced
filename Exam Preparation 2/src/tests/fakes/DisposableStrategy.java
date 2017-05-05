package tests.fakes;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 22.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DisposableStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        return null;
    }
}
