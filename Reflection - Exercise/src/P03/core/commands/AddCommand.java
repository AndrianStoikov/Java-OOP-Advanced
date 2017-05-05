package P03.core.commands;

import P03.annotations.Inject;
import P03.contracts.Executable;
import P03.contracts.Repository;
import P03.contracts.Unit;
import P03.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand implements Executable {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    @Override
    public String execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        String unitName = data[1];
        Unit unit = this.unitFactory.createUnit(unitName);
        this.repository.addUnit(unit);
        return unitName + " added!";
    }
}
