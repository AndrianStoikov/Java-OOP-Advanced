package core;

import collection.EmergencyRegister;
import collection.Register;
import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

import java.util.*;

public class EmergencyManagementSystem implements ManagementSystem {

    private static final String REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_AT_TIME = "Registered Public %s Emergency of level %s at %s.";
    private static final String PROPERTY = "Property";
    private static final String HEALTH = "Health";
    private static final String ORDER = "Order";

    private static final String FIRE = "Fire";
    private static final String MEDICAL = "Medical";
    private static final String POLICE = "Police";

    private static final String REGISTERED_SERVICE_EMERGENCY_CENTER = "Registered %s Service Emergency Center - %s.";
    private static final String SUCCESSFULLY_RESPONDED_TO_ALL_EMERGENCIES = "Successfully responded to all %s emergencies.";
    private static final String EMERGENCIES_LEFT_TO_PROCESS = "%s Emergencies left to process: %s.";
    private static final long INITIAL_VALUE = 0L;

    private Map<String, Register<Emergency>> emergencies;
    private Map<String, Register<EmergencyCenter>> centers;
    private Map<String, Long> resultsOfProcessedEmergencies;
    private int totalProcessedEmergencies;

    public EmergencyManagementSystem() {
        this.inicializeEmergencies();
        this.inicializeCenters();
        this.inicializeResultCollection();
    }

    private void inicializeResultCollection() {
        this.resultsOfProcessedEmergencies = new HashMap<>();
        this.resultsOfProcessedEmergencies.put(PROPERTY, INITIAL_VALUE);
        this.resultsOfProcessedEmergencies.put(HEALTH, INITIAL_VALUE);
        this.resultsOfProcessedEmergencies.put(ORDER, INITIAL_VALUE);
    }

    private void inicializeCenters() {
        this.centers = new LinkedHashMap<>();
        this.centers.put(PROPERTY, new EmergencyRegister<>());
        this.centers.put(HEALTH, new EmergencyRegister<>());
        this.centers.put(ORDER, new EmergencyRegister<>());
    }

    private void inicializeEmergencies() {
        this.emergencies = new LinkedHashMap<>();
        this.emergencies.put(PROPERTY, new EmergencyRegister<>());
        this.emergencies.put(HEALTH, new EmergencyRegister<>());
        this.emergencies.put(ORDER, new EmergencyRegister<>());
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.emergencies.get(PROPERTY).enqueueEmergency(emergency);
        return String.format(REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_AT_TIME,
                PROPERTY,
                emergency.getEmergencyLevel(),
                emergency.getRegistrationTime());
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.emergencies.get(HEALTH).enqueueEmergency(emergency);
        return String.format(REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_AT_TIME,
                HEALTH,
                emergency.getEmergencyLevel(),
                emergency.getRegistrationTime());
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.emergencies.get(ORDER).enqueueEmergency(emergency);
        return String.format(REGISTERED_PUBLIC_EMERGENCY_OF_LEVEL_AT_TIME,
                ORDER,
                emergency.getEmergencyLevel(),
                emergency.getRegistrationTime());
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter center) {
        this.centers.get(PROPERTY).enqueueEmergency(center);
        return String.format(REGISTERED_SERVICE_EMERGENCY_CENTER,
                FIRE,
                center.getName());
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter center) {
        this.centers.get(HEALTH).enqueueEmergency(center);
        return String.format(REGISTERED_SERVICE_EMERGENCY_CENTER,
                MEDICAL,
                center.getName());
    }

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter center) {
        this.centers.get(ORDER).enqueueEmergency(center);
        return String.format(REGISTERED_SERVICE_EMERGENCY_CENTER,
                POLICE,
                center.getName());
    }

    @Override
    public String processEmergencies(String type) {
        Register<Emergency> emergenciesToProcess = this.emergencies.get(type);
        Register<EmergencyCenter> processCenters = this.centers.get(type);

        while (!emergenciesToProcess.isEmpty()) {
            if (processCenters.isEmpty()) {
                return String.format(
                        "%s Emergencies left to process: %d.",
                        type, emergenciesToProcess.size());
            }
            EmergencyCenter currentCenter = processCenters.dequeueEmergency();
            if (currentCenter.isForRetirement()) {
                continue;
            }
            Emergency currentEmergency = emergenciesToProcess.dequeueEmergency();
            Long currentResult = this.resultsOfProcessedEmergencies.get(type);
            this.resultsOfProcessedEmergencies.put(
                    type, currentResult + currentEmergency.getValue());
            currentCenter.processEmergency(currentEmergency);
            processCenters.enqueueEmergency(currentCenter);
            this.totalProcessedEmergencies++;
        }
        return String.format(
                "Successfully responded to all %s emergencies.", type);

    }

    @Override
    public String emergencyReport() {
        for (Register<EmergencyCenter> centerRegister : this.centers.values()) {
            List<EmergencyCenter> temp = new LinkedList<>();
            while (!centerRegister.isEmpty()) {
                EmergencyCenter currentCenter = centerRegister.dequeueEmergency();
                if (currentCenter.isForRetirement()) {
                    continue;
                }
                temp.add(currentCenter);
            }
            for (EmergencyCenter emergencyCenter : temp) {
                centerRegister.enqueueEmergency(emergencyCenter);
            }
        }
        StringBuilder builder = new StringBuilder();
        Integer allRegisteredEmergencies = this.emergencies.entrySet().stream().
                mapToInt(currentEmergencies -> currentEmergencies.getValue().size()).sum();

        builder.append(String.format("PRRM Services Live Statistics%n"));
        builder.append(
                String.format("Fire Service Centers: %d%n", this.centers.get(PROPERTY).size()));
        builder.append(
                String.format("Medical Service Centers: %d%n", this.centers.get(HEALTH).size()));
        builder.append(
                String.format("Police Service Centers: %d%n", this.centers.get(ORDER).size()));
        builder.append(
                String.format("Total Processed Emergencies: %d%n", this.totalProcessedEmergencies));
        builder.append(
                String.format("Currently Registered Emergencies: %d%n", allRegisteredEmergencies));
        builder.append(String.format(
                "Total Property Damage Fixed: %d%n", this.resultsOfProcessedEmergencies.get(PROPERTY)));
        builder.append(String.format(
                "Total Health Casualties Saved: %d%n", this.resultsOfProcessedEmergencies.get(HEALTH)));
        builder.append(String.format(
                "Total Special Cases Processed: %d", this.resultsOfProcessedEmergencies.get(ORDER)));
        return builder.toString();
    }
}