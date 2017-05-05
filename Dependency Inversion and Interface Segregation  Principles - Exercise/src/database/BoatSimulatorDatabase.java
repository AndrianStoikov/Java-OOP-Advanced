package database;

import Utility.Constants;
import contracts.BoatEngine;
import contracts.IBoatSimulatorDatabase;
import contracts.IRace;
import contracts.IRepository;
import exceptions.DuplicateModelException;
import exceptions.NoSetRaceException;
import exceptions.RaceAlreadyExistsException;
import models.boats.MotorBoat;

public class BoatSimulatorDatabase implements IBoatSimulatorDatabase {
    private IRepository<MotorBoat> boats;
    private IRepository<BoatEngine> engines;
    private IRace race;

    public BoatSimulatorDatabase(IRepository<MotorBoat> boatRepository,
                                 IRepository<BoatEngine> engineRepository)
    {
        this.setBoats(boatRepository);
        this.setEngines(engineRepository);
    }

    private void setBoats(IRepository<MotorBoat> boats) {
        this.boats = boats;
    }

    private void setEngines(IRepository<BoatEngine> engines) {
        this.engines = engines;
    }

    @Override
    public IRepository<MotorBoat> getBoats() {
        return this.boats;
    }

    @Override
    public IRepository<BoatEngine> getEngines() {
        return this.engines;
    }

    @Override
    public IRace getRace() throws NoSetRaceException {
        if(this.race == null)
            throw new NoSetRaceException(Constants.NoSetRaceMessage);

        return this.race;
    }

    @Override
    public void addRace(IRace race) throws RaceAlreadyExistsException {
        if(this.race != null)
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        this.race = race;
    }

    @Override
    public void addEngine(BoatEngine engine) throws DuplicateModelException {
        this.engines.Add(engine);
    }

    @Override
    public void addBoat(MotorBoat boat) throws DuplicateModelException {
        this.boats.Add(boat);
    }

    @Override
    public void clearRace() {
        this.race = null;
    }
}
