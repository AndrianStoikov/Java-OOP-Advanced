package P04_WorkForce;

import P04_WorkForce.writers.ConsoleWriter;
import P04_WorkForce.writers.Writer;
import P04_WorkForce.data.DataBase;
import P04_WorkForce.data.IDataBase;


import java.io.IOException;

/**
 * Created by Andrian on 13.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Main {
    public static void main(String[] args) throws IOException {
        Writer writer =new ConsoleWriter();
        IDataBase dataBase = new DataBase(writer);
        Engine engine = new Engine(dataBase);
        engine.run();
    }
}
