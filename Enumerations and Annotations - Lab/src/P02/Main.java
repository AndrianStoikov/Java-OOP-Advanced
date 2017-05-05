package P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

        String loggerImportance = Console.readLine();
        Logger logger = new Logger(loggerImportance);

        while(true) {
            String[] input = Console.readLine().split(": ");
            if(input[0].equals("END"))
                break;

            Message message = new Message(input[0], input[1]);
            logger.addMessage(message);

        }

        logger.getMessages().forEach(System.out::println);
    }
}
