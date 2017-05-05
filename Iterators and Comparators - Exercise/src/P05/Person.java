package P05;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person p) {
        if (this.name.equals(p.getName()))
            if (this.age == p.getAge())
                if (this.town.equals(p.getTown()))
                    return 0;

        return 1;

    }
}
