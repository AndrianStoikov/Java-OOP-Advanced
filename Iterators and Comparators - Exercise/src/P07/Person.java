package P07;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person))
            return false;

        if(this.age == ((Person) obj).age)
            if(this.name.equals(((Person) obj).name))
                return true;

        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 37 + this.age;
        hashCode = hashCode * 37 + this.name.hashCode();
        return hashCode;
    }

    @Override
    public int compareTo(Person o) {
        int compRes = Integer.compare(this.age, o.age);
        if(compRes != 0)
            return compRes;

        return this.name.compareTo(o.name);
    }
}
