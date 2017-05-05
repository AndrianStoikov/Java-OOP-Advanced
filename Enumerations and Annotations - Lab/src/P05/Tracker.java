package P05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Tracker {

    @Author(name = "Andrian")
    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] declaredMethods = cl.getDeclaredMethods();

        HashMap<String, ArrayList<String>> anotatedMethods = new HashMap<>();
        for (Method declaredMethod : declaredMethods) {
            Author annotation = declaredMethod.getDeclaredAnnotation(Author.class);
            if (annotation == null)
                continue;

            anotatedMethods.putIfAbsent(annotation.name(), new ArrayList<>());
            anotatedMethods.get(annotation.name()).add(declaredMethod.getName() + "()");
        }

        for (String name : anotatedMethods.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(": ").append(String.join(", ", anotatedMethods.get(name)));
            System.out.println(sb.toString());
        }
    }

    @Deprecated
    @Author(name = "Anastasiq")
    private static int asd() {
        return 0;
    }
}
