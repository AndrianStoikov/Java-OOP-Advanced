package engines;

import interpreters.Interpreter;
import io.readers.Reader;
import io.writers.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("DefaultFileTemplate")
public class Engine implements Runnable {
    private Reader reader;
    private Writer writer;
    private Interpreter interpreter;

    public Engine(Reader reader,
                  Writer writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String[] cmdArgs = this.reader.read().split("\\|");
                String type = cmdArgs[0];
                if ("EmergencyBreak".equals(type))
                    return;


                String[] data = new String[cmdArgs.length - 1];
                System.arraycopy(cmdArgs, 1, data, 0, cmdArgs.length - 1);

                this.writer.writeln(this.interpreter.interperateCommand(type, data));
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
