package P02;

public class Citizen implements Person, Birthable, Identifiable {
    private String name;
    private Integer age;
    private String birthDay;
    private String id;

    public Citizen(String name, Integer age, String birthDay, String id) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getBirthDay() {
        return this.birthDay;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
