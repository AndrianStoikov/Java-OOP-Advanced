package P06;


public class Citizen implements Inhabitable, BirthdayInhabitant {
    private String id;
    private String name;
    private Integer age;
    private String birthDay;

    public Citizen(String id, String name, Integer age, String birthDay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }
}
