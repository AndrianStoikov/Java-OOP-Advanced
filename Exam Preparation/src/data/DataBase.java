package data;

import collection.RegisterCollection;
import models.emergencyCenters.FiremanServiceCenter;
import models.emergencyCenters.MedicalServiceCenter;
import models.emergencyCenters.PoliceServiceCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class DataBase implements IDataBase {
    private RegisterCollection collection;
    private List<FiremanServiceCenter> fireCenters;
    private List<MedicalServiceCenter> medicalCenters;
    private List<PoliceServiceCenter> policeCenters;

    public DataBase(RegisterCollection collection) {
        this.collection = collection;
        this.fireCenters = new ArrayList<>();
        this.medicalCenters = new ArrayList<>();
        this.policeCenters = new ArrayList<>();
    }

    @Override
    public RegisterCollection getRegisterCollection() {
        return this.collection;
    }

    @Override
    public void addFireEmergencyCenter(FiremanServiceCenter center) {
        this.fireCenters.add(center);
    }

    @Override
    public void addMedicalEmergencyCenter(MedicalServiceCenter center) {
        this.medicalCenters.add(center);
    }

    @Override
    public void addPoliceEmergencyCenter(PoliceServiceCenter center) {
        this.policeCenters.add(center);
    }

    @Override
    public List<FiremanServiceCenter> getFireEmergencyCenter() {
        return this.fireCenters;
    }

    @Override
    public List<MedicalServiceCenter> getMedicalEmergencyCenter() {
        return this.medicalCenters;
    }

    @Override
    public List<PoliceServiceCenter> getPoliceEmergencyCenter() {
        return this.policeCenters;
    }
}
