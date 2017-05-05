package P07;

/**
 * Created by Andrian on 16.3.2017 г..
 */
public class Citizen implements Buyer {
    private String id;
    private String name;
    private Integer age;
    private String birthDay;
    private Integer food;

    public Citizen(String name, Integer age,String id, String birthDay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public Integer getFood() {
        return this.food;
    }
}
