package core.engines;


import annotations.Inject;
import core.ManagementSystem;
import data.IDataBase;
import readers.Reader;
import writers.Writer;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Andrian on 15.4.2017 г..
 */
@SuppressWarnings("DefaultFileTemplate")
public class Engine implements Runnable {
    private Writer writer;
    private Reader reader;
    private IDataBase dataBase;
    private ManagementSystem system;

    public Engine(Writer writer, Reader reader, IDataBase dataBase, ManagementSystem system) {
        this.writer = writer;
        this.reader = reader;
        this.dataBase = dataBase;
        this.system = system;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String[] cmdArgs = this.reader.readLine().split("\\|");
                if("EmergencyBreak".equals(cmdArgs[0]))
                    return;

                this.injectSystemDependecies();
                this.execCommand(cmdArgs);
            } catch (IOException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void execCommand(String[] cmdArgs) {
        String command = cmdArgs[0];
        String[] data = new String[cmdArgs.length - 1];
        System.arraycopy(cmdArgs, 1, data, 0, cmdArgs.length - 1);
        switch (command) {
            case "RegisterPropertyEmergency": {
                this.writer.printLn(this.system.registerPropertyEmergency(data));
            } break;
            case "RegisterHealthEmergency": {
                this.writer.printLn(this.system.registerHealthEmergency(data));
            } break;
            case "RegisterOrderEmergency": {
                this.writer.printLn(this.system.registerOrderEmergency(data));
            } break;
            case "RegisterFireServiceCenter": {
                this.writer.printLn(this.system.registerFireServiceCenter(data));
            } break;
            case "RegisterMedicalServiceCenter": {
                this.writer.printLn(this.system.registerMedicalServiceCenter(data));
            } break;
            case "RegisterPoliceServiceCenter": {
                this.writer.printLn(this.system.registerPoliceServiceCenter(data));
            } break;
            case "ProcessEmergencies": {
                this.writer.printLn(this.system.processEmergencies(data));
            } break;
        }
    }

    private void injectSystemDependecies() throws IllegalAccessException {
        Field[] systemFields = this.system.getClass().getDeclaredFields();
        for (Field systemField : systemFields) {
            if(systemField.isAnnotationPresent(Inject.class)) {
                systemField.setAccessible(true);

                Field[] engineFields = this.getClass().getDeclaredFields();
                for (Field engineField : engineFields) {
                    if(systemField.getType().equals(engineField.getType())) {
                        engineField.setAccessible(true);
                        systemField.set(this.system, engineField.get(this));
                    }
                }
            }
        }
    }
}
