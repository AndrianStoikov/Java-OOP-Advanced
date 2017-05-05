package P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String command = Console.readLine();
            if ("HARVEST".equals(command))
                return;

            execCommand(command, RichSoilLand.class);
        }
    }

    private static void execCommand(String command, Class<?> cl) {
        switch (command) {
            case "private": {
                for (Field field : cl.getDeclaredFields()) {
                    if (Modifier.isPrivate(field.getModifiers()))
                        System.out.println(fieldToString(field));
                }
            }
            break;
            case "protected": {
                for (Field field : cl.getDeclaredFields()) {
                    if (Modifier.isProtected(field.getModifiers()))
                        System.out.println(fieldToString(field));
                }
            }
            break;
            case "public": {
                for (Field field : cl.getDeclaredFields()) {
                    if (Modifier.isPublic(field.getModifiers()))
                        System.out.println(fieldToString(field));
                }
            }
            break;
            case "all": {
                for (Field field : cl.getDeclaredFields()) {
                    System.out.println(fieldToString(field));
                }
            }
            break;
            default:
        }
    }

    private static String fieldToString(Field field) {
        return String.format("%s %s %s",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName());
    }
}
