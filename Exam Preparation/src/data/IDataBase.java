package data;

import collection.RegisterCollection;
import models.emergencyCenters.FiremanServiceCenter;
import models.emergencyCenters.MedicalServiceCenter;
import models.emergencyCenters.PoliceServiceCenter;

import java.util.List;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public interface IDataBase {
    RegisterCollection getRegisterCollection();

    void addFireEmergencyCenter(FiremanServiceCenter center);

    void addMedicalEmergencyCenter(MedicalServiceCenter center);

    void addPoliceEmergencyCenter(PoliceServiceCenter center);

    List<FiremanServiceCenter> getFireEmergencyCenter();

    List<MedicalServiceCenter> getMedicalEmergencyCenter();

    List<PoliceServiceCenter> getPoliceEmergencyCenter();
}
