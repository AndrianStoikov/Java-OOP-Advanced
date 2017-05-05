package P04_WorkForce.models;

import P04_WorkForce.contracts.Nameable;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class StandartEmployee extends NameableEmployee {

    private static final int WORKING_HOURS_PER_WEEK = 40;
    private int workHours;

    public StandartEmployee(String name) {
        super(name);
        this.workHours = WORKING_HOURS_PER_WEEK;
    }

    @Override
    public int getWorkHours() {
        return this.workHours;
    }
}
