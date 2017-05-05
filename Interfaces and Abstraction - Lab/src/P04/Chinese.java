package P04;

/**
 * Created by Andrian on 15.3.2017 г..
 */
public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
