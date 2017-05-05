package P01;

/**
 * Created by Andrian on 17.3.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(2);
        jar.add(3);

        System.out.println(jar.remove());
    }
}
