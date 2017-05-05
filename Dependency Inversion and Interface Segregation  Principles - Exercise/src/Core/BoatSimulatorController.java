package Core;

import contracts.*;
import exceptions.NoSetRaceException;
import factories.BoatEngineFactory;
import models.Race;
import models.boats.*;

public class BoatSimulatorController implements IBoatSimulatorController {
    private IBoatSimulatorDatabase database;

    public BoatSimulatorController(IBoatSimulatorDatabase database) {
        this.database = database;
    }

    private String getBoatName(MotorBoat boat) {
        int index = boat.getClass().getSimpleName().indexOf("Boat");
        if(index == -1)
            return boat.getClass().getSimpleName();
        else {
            return boat.getClass().getSimpleName().substring(0, index) + " boat";
        }
    }

    @Override
    public String CreateBoatEngine(String model, int horsePower, int displacement, String type) throws Exception {
        BoatEngine engine = BoatEngineFactory.createEngine(
                model,
                horsePower,
                displacement,
                type);
        this.database.addEngine(engine);

        return String.format("Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsePower,
                displacement);
    }

    @Override
    public String CreateRowBoat(String model, int weight, int oars) throws Exception {
        MotorBoat boat = new RowBoat(model, weight, oars);
        this.database.addBoat(boat);

        return String.format("%s with model %s registered successfully.",
                this.getBoatName(boat),
                model);
    }

    @Override
    public String CreateSailBoat(String model, int weight, int sailEficiency) throws Exception {
        MotorBoat boat = new SailBoat(model, weight, sailEficiency);
        this.database.addBoat(boat);

        return String.format("%s with model %s registered successfully.",
                this.getBoatName(boat),
                model);
    }

    @Override
    public String CreatePowerBoat(String model, int weight, String engine1Name, String engine2Name) throws Exception {
        BoatEngine engine1 = this.database.getEngines().GetItem(engine1Name);
        BoatEngine engine2 = this.database.getEngines().GetItem(engine2Name);
        MotorBoat boat = new PowerBoat(model, weight, engine1, engine2);
        this.database.addBoat(boat);

        return String.format("%s with model %s registered successfully.",
                this.getBoatName(boat),
                model);
    }

    @Override
    public String CreateYacht(String model, int weight, String engineName, int cargoWeigth) throws Exception {
        BoatEngine engine = this.database.getEngines().GetItem(engineName);
        MotorBoat boat = new Yacht(model, weight, engine, cargoWeigth);
        this.database.addBoat(boat);

        return String.format("%s with model %s registered successfully.",
                this.getBoatName(boat),
                model);
    }

    @Override
    public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) throws Exception{
        IRace race = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorBoats);
        this.database.addRace(race);

        return String.format("A new race with distance %d meters, wind speed %d m/s and ocean current speed %d m/s has been set.",
                distance,
                windSpeed,
                oceanCurrentSpeed);
    }

    @Override
    public String SignUpBoat(String model) throws Exception{
        MotorBoat boat = database.getBoats().GetItem(model);
        database.getRace().AddParticipant(boat);

        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String StartRace() throws NoSetRaceException {
        String result = this.database.getRace().start();
        if(!result.equals("Not enough contestants for the race."))
            this.database.clearRace();

        return result;
    }

    @Override
    public String GetStatistic() {
        return null;
    }
}
