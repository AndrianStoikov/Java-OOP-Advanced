package P03.core;

import P03.annotations.Inject;
import P03.contracts.CommandFactory;
import P03.contracts.Executable;
import P03.contracts.Repository;
import P03.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    private CommandFactory factory;

    public Engine(Repository repository, UnitFactory unitFactory, CommandFactory commandFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.factory = commandFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpredCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                sb.append(result).append(System.lineSeparator());
            } catch (RuntimeException | IOException | InstantiationException | NoSuchMethodException |
                    IllegalAccessException | ClassNotFoundException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(sb);
    }

    private String interpredCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Executable executable = this.factory.createCommand(commandName);
        this.injectDependecies(executable);
        return executable.execute(data);
    }

    private void injectDependecies(Executable executable) throws IllegalAccessException {
        Class<?> aClass = executable.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();

                for (Field fieldToInject : this.getClass().getDeclaredFields()) {
                    if(fieldType.equals(fieldToInject.getType())) {
                        field.setAccessible(true);
                        field.set(executable, fieldToInject.get(this));
                    }

                }
            }
        }
    }
}
