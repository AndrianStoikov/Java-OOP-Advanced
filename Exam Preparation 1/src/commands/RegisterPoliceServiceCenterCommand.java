package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;
import models.centers.PoliceServiceCenter;

/**
 * Created by Andrian on 19.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class RegisterPoliceServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private String[] data;

    private EmergencyCenter center;

    public RegisterPoliceServiceCenterCommand(ManagementSystem system) {
        super(system);
    }

    @Override
    public String execute() {
        ManagementSystem system = super.getManagementSystem();

        String name = this.data[0];
        int emergencies = Integer.parseInt(this.data[1]);
        this.center = new PoliceServiceCenter(name, emergencies);
        return system.registerPoliceServiceCenter(this.center);
    }
}
