package P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator iterator = createIterator(Console);


        while (true) {
            String input = Console.readLine();
            if("END".equals(input))
                break;

            String[] cmdArgs = input.split("\\s+");

            try {
                execCommand(cmdArgs,iterator);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private static ListyIterator createIterator(BufferedReader Console) throws IOException, IllegalArgumentException {
        String[] create = Console.readLine().split(" ");
        String[] args = new String[create.length - 1];

        for (int i = 1; i < create.length; i++) {
            args[i -1] = create[i];
        }

        return new ListyIterator(args);
    }

    private static void execCommand(String[] cmdArgs, ListyIterator iterator) {
        switch (cmdArgs[0]) {
            case "Move": {
                System.out.println(iterator.move());
            } break;
            case "Print": {
                System.out.println(iterator.print());
            } break;
            case "HasNext": {
                System.out.println(iterator.hasNext());
            } break;
            case "PrintAll": {
                System.out.println(iterator.printAll());
            } break;
        }
    }
}
