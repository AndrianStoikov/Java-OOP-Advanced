package P03.core.factories;

import P03.contracts.Unit;
import P03.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "P03.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        return (Unit) constructor.newInstance();
    }
}
