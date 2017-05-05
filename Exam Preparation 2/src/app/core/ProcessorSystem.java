package app.core;

import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface ProcessorSystem {
    String processGarbageCommandExecuted(Waste waste);

    String statusCommandExecuted();
}
