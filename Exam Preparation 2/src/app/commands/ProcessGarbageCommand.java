package app.commands;

import app.annotations.InjectData;
import app.core.ProcessorSystem;
import app.factories.WasteFactory;
import app.waste_disposal.contracts.Waste;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class ProcessGarbageCommand extends BaseCommand {

    @InjectData
    private String[] data;

    public ProcessGarbageCommand(ProcessorSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        String name = data[0];
        double weight = Double.parseDouble(data[1]);
        double volumePerKg = Double.parseDouble(data[2]);
        String type = data[3];
        Waste waste = WasteFactory.create(type, name, weight, volumePerKg);
        return super.getSystem().processGarbageCommandExecuted(waste);
    }
}
