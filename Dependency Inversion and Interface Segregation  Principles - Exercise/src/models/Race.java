package models;

import Utility.Constants;
import Utility.Validator;
import contracts.IRace;
import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.boats.MotorBoat;

import java.util.*;
import java.util.stream.Collectors;

public class Race implements IRace {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;

    private Boolean allowsMotorBoats;
    private HashMap<String, MotorBoat> registeredBoats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) throws ArgumentException {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new LinkedHashMap<>();
    }

    private void setDistance(int distance) throws ArgumentException {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    private void setOceanCurrentSpeed(int oseanCurrentSpeed) {
        this.oceanCurrentSpeed = oseanCurrentSpeed;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    @Override
    public void AddParticipant(MotorBoat boat) throws DuplicateModelException, ArgumentException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        if (boat.isMotorBoat() && this.allowsMotorBoats) {
            this.registeredBoats.put(boat.getModel(), boat);
            return;
        }

        if (!boat.isMotorBoat()) {
            this.registeredBoats.put(boat.getModel(), boat);
        }
        else
            throw new ArgumentException("The specified boat does not meet the race constraints.");


    }

    @Override
    public List<MotorBoat> GetParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }

    @Override
    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public String start() {
        if(this.registeredBoats.size() < 3)
            return "Not enough contestants for the race.";

        Map<String, MotorBoat> map = this.registeredBoats.entrySet().stream()
                .sorted((e1, e2) -> {
                    double firstBoat = e1.getValue().getSpeed(this);
                    double secondBoat = e2.getValue().getSpeed(this);
                    return Double.compare(secondBoat, firstBoat);
                })
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1,v2)->v1,
                    LinkedHashMap::new)
                );

        StringBuilder sb = new StringBuilder();
        getOutput(map, sb);
        return sb.toString().trim();
    }

    private void getOutput(Map<String, MotorBoat> map, StringBuilder sb) {
        int i = 1;

        String result;
        for (MotorBoat boat : map.values()) {
            double speed = boat.getSpeed(this);
            String place = "";
            if (i == 1)
                place = "First";
            if (i == 2)
                place = "Second";
            else if(i == 3)
                place = "Third";

            if (speed <= 0)
                result = String.format("%s place: %s Model: %s Time: Did not finish!",
                        place,
                        boat.getType(),
                        boat.getModel());
            else {
                result = String.format("%s place: %s Model: %s Time: %.2f sec",
                        place,
                        boat.getType(),
                        boat.getModel(),
                        this.distance / speed);
            }
            sb.append(result).append(System.lineSeparator());
            i++;
        }
    }
}