package contracts;

import exceptions.DuplicateModelException;
import exceptions.NoSetRaceException;
import exceptions.RaceAlreadyExistsException;
import models.boats.MotorBoat;

public interface IBoatSimulatorDatabase {
    IRepository<MotorBoat> getBoats();

    IRepository<BoatEngine> getEngines();

    IRace getRace() throws NoSetRaceException;

    void addEngine(BoatEngine engine) throws DuplicateModelException;

    void addBoat(MotorBoat boat) throws DuplicateModelException;

    void addRace(IRace race) throws RaceAlreadyExistsException;

    void clearRace();
}
