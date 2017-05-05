package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;
import models.centers.FiremanServiceCenter;
import models.centers.MedicalServiceCenter;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegisterFireServiceCenterCommand extends BaseCommand {
    @InjectArgs
    private String[] data;

    private EmergencyCenter center;

    public RegisterFireServiceCenterCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = super.getManagementSystem();

        String name = this.data[0];
        int emergencies = Integer.parseInt(this.data[1]);
        this.center = new FiremanServiceCenter(name, emergencies);
        return system.registerFireServiceCenter(this.center);
    }
}
