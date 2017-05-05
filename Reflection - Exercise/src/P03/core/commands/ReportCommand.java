package P03.core.commands;

import P03.annotations.Inject;
import P03.contracts.Executable;
import P03.contracts.Repository;

import java.lang.reflect.InvocationTargetException;


public class ReportCommand implements Executable {

    @Inject
    private Repository repository;

    @Override
    public String execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        return this.repository.getStatistics();
    }
}
