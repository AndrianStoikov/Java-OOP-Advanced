package P06;


public class Pet implements BirthdayInhabitant, Inhabitable{
    private String name;
    private String birthDay;

    public Pet(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }

}
