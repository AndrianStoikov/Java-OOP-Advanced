package P04_WorkForce.models;

import P04_WorkForce.contracts.Nameable;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public abstract class NameableEmployee implements Nameable, Employee {
    private String name;

    protected NameableEmployee(String name) {
        this.name =name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
