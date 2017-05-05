package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;
import models.centers.MedicalServiceCenter;
import models.centers.PoliceServiceCenter;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegisterMedicalServiceCenterCommand extends BaseCommand {
    @InjectArgs
    private String[] data;

    private EmergencyCenter center;

    public RegisterMedicalServiceCenterCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = super.getManagementSystem();

        String name = this.data[0];
        int emergencies = Integer.parseInt(this.data[1]);
        this.center = new MedicalServiceCenter(name, emergencies);
        return system.registerMedicalServiceCenter(this.center);
    }
}
