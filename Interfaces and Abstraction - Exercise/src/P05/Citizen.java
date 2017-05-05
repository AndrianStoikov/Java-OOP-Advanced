package P05;


public class Citizen implements Inhabitable {
    private String id;
    private String name;
    private Integer age;

    public Citizen(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
