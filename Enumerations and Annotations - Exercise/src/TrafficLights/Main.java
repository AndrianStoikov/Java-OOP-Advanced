package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        Light[] lights = Arrays.stream(Console.readLine().split(" "))
                .map(Light::valueOf)
                .toArray(Light[]::new);

        int n = Integer.parseInt(Console.readLine());

        for (int i = 0; i < n; i++) {
            swapElements(lights);
            System.out.println(elementsToString(lights));
        }
    }

    private static String elementsToString(Light[] lights) {
        StringBuilder sb = new StringBuilder();
        for (Light light : lights) {
            sb.append(light.toString()).append(" ");
        }
        return sb.toString().trim();
    }

    private static void swapElements(Light[] lights) {
        for (int i = 0; i < lights.length; i++) {
            String newType = getNewType(lights[i].ordinal() + 1);
            lights[i] = Light.valueOf(newType);
        }
    }

    private static String getNewType(int num) {
        switch (num) {
            case 1: return "YELLOW";
            case 2: return "RED";
            default: return "GREEN";
        }
    }


}
