import collection.EmergencyRegister;
import collection.Register;
import core.EmergencyManagementSystem;
import engines.Engine;
import core.ManagementSystem;
import interpreters.CommandInterpreter;
import interpreters.Interpreter;
import io.readers.ConsoleReader;
import io.readers.Reader;
import io.writers.ConsoleWriter;
import io.writers.Writer;

/**
 * Created by Andrian on 18.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Main {
    public static void main(String[] args) {
        ManagementSystem system = new EmergencyManagementSystem();
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Interpreter interpreter = new CommandInterpreter(system);

        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();
    }
}
