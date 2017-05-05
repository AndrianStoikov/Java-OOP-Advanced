package contracts;


import exceptions.ArgumentException;
import exceptions.NoSetRaceException;

public interface IBoatSimulatorController {
    String CreateBoatEngine(String model, int horsePower, int displacement, String type) throws Exception;

    String CreateRowBoat(String s, int i, int i1) throws ArgumentException, Exception;

    String CreateSailBoat(String s, int i, int i1) throws Exception;

    String CreatePowerBoat(String s, int i, String s1, String s2) throws Exception;

    String CreateYacht(String s, int i, String s1, int i1) throws Exception;

    String OpenRace(int i, int i1, int i2, boolean b) throws Exception;

    String SignUpBoat(String s) throws Exception;

    String StartRace() throws NoSetRaceException;

    String GetStatistic();
}
