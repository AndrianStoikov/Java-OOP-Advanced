package app.core;

import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DefaultProcessSystem implements ProcessorSystem {

    private static final String KG_OF_WASTE_SUCCESSFULLY_PROCESSED = "%.2f kg of %s successfully processed!";
    private static final String ENERGY_CAPITAL = "Energy: %.2f Capital: %.2f";
    private GarbageProcessor processor;
    private double energy;
    private double capital;

    public DefaultProcessSystem(GarbageProcessor processor) {
        this.processor = processor;
        this.energy = 0;
        this.capital = 0;
    }

    @Override
    public String processGarbageCommandExecuted(Waste waste) {
        ProcessingData data = this.processor.processWaste(waste);
        this.energy += data.getEnergyBalance();
        this.capital += data.getCapitalBalance();

        return String.format(KG_OF_WASTE_SUCCESSFULLY_PROCESSED,
                waste.getWeight(),
                waste.getName());
    }

    @Override
    public String statusCommandExecuted() {
        return String.format(ENERGY_CAPITAL,
                this.energy,
                this.capital);
    }
}
