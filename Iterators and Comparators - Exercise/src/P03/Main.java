package P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        CustomStack stack = new CustomStack();
        while (true) {
            String[] input = Console.readLine().split("[ ,]+");
            if("END".equals(input[0]))
                break;

            try {
                execCommand(stack, input);
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(stack.print());
        System.out.println(stack.print());
    }

    private static void execCommand(CustomStack stack, String[] input) throws IllegalAccessException {
        switch (input[0]) {
            case "Push": {
                for (int i = 1; i < input.length; i++) {
                    stack.push(Integer.valueOf(input[i]));
                }
            } break;
            case "Pop": {
                stack.pop();
            } break;
        }
    }
}
