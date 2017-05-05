import Core.BoatSimulatorController;
import Core.CommandHandler;
import Core.Engine;
import contracts.*;
import database.BoatSimulatorDatabase;
import database.Repository;
import models.boats.MotorBoat;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IRepository<MotorBoat> boatRepository = new Repository<>();
        IRepository<BoatEngine> engineRepository = new Repository<>();
        IBoatSimulatorDatabase database = new BoatSimulatorDatabase(boatRepository, engineRepository);
        IBoatSimulatorController controller = new BoatSimulatorController(database);
        ICommandHandler commandHandler = new CommandHandler(controller);
        Runable engine = new Engine(commandHandler, database);
        engine.run();
    }
}
