package P03.core.commands;

import P03.contracts.Executable;

import java.lang.reflect.InvocationTargetException;

public class FightCommand implements Executable {
    @Override
    public String execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}
