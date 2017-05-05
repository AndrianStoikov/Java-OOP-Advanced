import collection.EmergencyRegister;
import collection.RegisterCollection;
import core.EmergencyManagementSystem;
import core.ManagementSystem;
import data.DataBase;
import data.IDataBase;
import core.engines.Engine;
import readers.ConsoleReader;
import readers.Reader;
import writers.ConsoleWriter;
import writers.Writer;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Main {
    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();
        RegisterCollection collection = new EmergencyRegister();
        IDataBase dataBase = new DataBase(collection);
        ManagementSystem system = new EmergencyManagementSystem();
        Runnable engine = new Engine(writer, reader, dataBase, system);
        engine.run();
    }
}
