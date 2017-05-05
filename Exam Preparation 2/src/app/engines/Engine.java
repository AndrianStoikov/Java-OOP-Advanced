package app.engines;

import app.commands.Executable;
import app.interpreters.Interpreter;
import app.io.readers.Reader;
import app.io.writers.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Andrian on 20.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Engine implements Runnable {
    private static final String STOP_COMMAND = "TimeToRecycle";

    private Interpreter interpreter;
    private Reader reader;
    private Writer writer;

    public Engine(Interpreter interpreter, Reader reader, Writer writer) {
        this.interpreter = interpreter;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String[] cmdArgs = this.reader.readLine().split("[ |]");
                String commandType = cmdArgs[0];
                if (STOP_COMMAND.equals(commandType))
                    return;

                String[] data = new String[cmdArgs.length - 1];
                System.arraycopy(cmdArgs, 1, data, 0, cmdArgs.length - 1);
                Executable executable = this.interpreter.interperateCommand(commandType, data);
                this.writer.writeLn(executable.execute());
            }
        } catch (IOException | InstantiationException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
