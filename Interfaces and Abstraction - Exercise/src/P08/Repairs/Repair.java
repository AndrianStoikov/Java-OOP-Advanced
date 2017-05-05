package P08.Repairs;

/**
 * Created by Andrian on 16.3.2017 г..
 */
public class Repair {
    private String partName;
    private Integer workedHours;


    public Repair(String partName, Integer workedHours) {
        this.partName = partName;
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.workedHours);
    }
}
