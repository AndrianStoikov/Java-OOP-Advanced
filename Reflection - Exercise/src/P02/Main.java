package P02;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        try {
            engine.Start();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                InstantiationException | IOException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
