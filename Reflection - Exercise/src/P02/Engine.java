package P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine {

    public Engine() {

    }

    public void Start() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Class<?> aClass = BlackBoxInt.class;
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt box = (BlackBoxInt) constructor.newInstance();
        while (true) {
            String[] command = Console.readLine().split("_");
            if ("END".equals(command[0]))
                return;

            execCommand(command, aClass, box);
            getResult(box);
        }
    }

    private void getResult(BlackBoxInt box) throws NoSuchFieldException, IllegalAccessException {
        Field value = box.getClass().getDeclaredField("innerValue");
        value.setAccessible(true);
        Object res = value.get(box);
        System.out.println(res);
    }

    private void execCommand(String[] command, Class<?> aClass, BlackBoxInt blackBoxInt) throws NoSuchFieldException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        switch (command[0]) {
            case "add": {
                Method method = aClass.getDeclaredMethod("add", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            }
            break;
            case "subtract": {
                Method method = aClass.getDeclaredMethod("subtract", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            }
            break;
            case "divide": {
                Method method = aClass.getDeclaredMethod("divide", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            }
            break;
            case "multiply": {
                Method method = aClass.getDeclaredMethod("multiply", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            }
            break;
            case "rightShift": {
                Method method = aClass.getDeclaredMethod("rightShift", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            }
            break;
            case "leftShift": {
                Method method = aClass.getDeclaredMethod("leftShift", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            }
            break;
        }
    }
}
