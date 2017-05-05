package P04;

/**
 * Created by Andrian on 15.3.2017 г..
 */
public class European implements Person {
    private String name;

    public European(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
