package core;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface ManagementSystem {
    String registerPropertyEmergency(String[] data);

    String registerHealthEmergency(String[] data);

    String registerOrderEmergency(String[] data);

    String registerFireServiceCenter(String[] data);

    String registerMedicalServiceCenter(String[] data);

    String registerPoliceServiceCenter(String[] data);

    String processEmergencies(String[] data);

    String emergencyReport(String[] data);
}
