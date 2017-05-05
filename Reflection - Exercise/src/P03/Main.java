package P03;

import P03.contracts.CommandFactory;
import P03.contracts.Repository;
import P03.contracts.UnitFactory;
import P03.core.Engine;
import P03.core.factories.CommandFactoryImpl;
import P03.core.factories.UnitFactoryImpl;
import P03.data.UnitRepository;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory factory = new UnitFactoryImpl();
        CommandFactory commandFactory = new CommandFactoryImpl();
        Engine engine = new Engine(repository, factory, commandFactory);
        engine.run();
    }
}
