package models.emergencyCenters;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;
    private Integer amountOfMaximumEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }
}
