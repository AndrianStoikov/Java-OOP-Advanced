package BlobProblem;

import BlobProblem.interfaces.Executable;
import BlobProblem.models.Blob;
import BlobProblem.models.factories.CommandFactory;
import Logger.annotations.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Engine implements Runnable {

    private Map<String, Blob> blobMap;


    public Engine() {
        this.blobMap = new LinkedHashMap<>();
    }

    @Override
    public void run() {
        BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String[] cmdArgs = Console.readLine().split(" ");
                if ("drop".equals(cmdArgs[0]))
                    return;

                execCommand(cmdArgs);
            } catch (IOException | InstantiationException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void execCommand(String[] cmdArgs) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Executable executable = CommandFactory.createCommand(cmdArgs);
        this.injectParms(executable);
        executable.execute(cmdArgs);
    }

    @SuppressWarnings("Duplicates")
    private void injectParms(Executable executable) throws IllegalAccessException {
        for (Field field : executable.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)) {
                for (Field fieldToInject : this.getClass().getDeclaredFields()) {
                    if(field.getType().equals(fieldToInject.getType())) {
                        field.setAccessible(true);
                        fieldToInject.setAccessible(true);
                        field.set(executable, fieldToInject.get(this));
                    }
                }
            }
        }
    }
}
