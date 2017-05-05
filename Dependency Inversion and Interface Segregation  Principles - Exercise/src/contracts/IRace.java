package contracts;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.boats.MotorBoat;

import java.util.List;

public interface IRace {

    void AddParticipant(MotorBoat boat) throws DuplicateModelException, ArgumentException;

    List<MotorBoat> GetParticipants();

    int getOceanCurrentSpeed();

    int getWindSpeed();

    String start();
}
