package main.io;

import main.Interfaces.Executable;
import main.annotations.Alias;
import main.annotations.Inject;
import main.judge.Tester;
import main.network.DownloadManager;
import main.repository.StudentsRepository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreter {

    private static final String COMMANDS_LOCATION = "src/main/io/commands";
    private static final String COMMANDS_PACKAGE = "main.io.commands.";
    private Tester tester;
    private StudentsRepository repository;
    private DownloadManager downloadManager;
    private IOManager ioManager;

    public CommandInterpreter(Tester tester,
                              StudentsRepository repository,
                              DownloadManager downloadManager,
                              IOManager ioManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(input, data, commandName);
            if(command == null) {
                return;
            }
            command.execute();
        } catch (Exception ex) {
            OutputWriter.displayException(ex.getMessage());
        }
    }

    private Executable parseCommand(String input, String[] data, String command) {
        File commandsFolder = new File(COMMANDS_LOCATION);
        Executable executable = null;
        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java"))
                continue;

            try {
                String className = file.getName()
                        .substring(0, file.getName().lastIndexOf('.'));

                @SuppressWarnings("unchecked")
                Class<Executable> exeClass = (Class<Executable>) Class.forName(
                        COMMANDS_PACKAGE + className);

                if (!exeClass.isAnnotationPresent(Alias.class))
                    continue;

                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();
                if(!value.equalsIgnoreCase(command))
                    continue;

                Constructor exeCtor = exeClass.getConstructor(String.class, String[].class);
                executable = (Executable) exeCtor.newInstance(input, data);
                this.injectDependecies(executable, exeClass);
            } catch (ReflectiveOperationException rfe) {
                rfe.printStackTrace();
            }
        }
        return executable;
    }

    private void injectDependecies(Executable executable, Class<Executable> exeClass) throws ReflectiveOperationException{
        Field[] declaredFields = exeClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if(!field.isAnnotationPresent(Inject.class))
                continue;
            field.setAccessible(true);

            Field[] fields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisField : fields) {
                if(!thisField.getType().equals(field.getType()))
                    continue;

                thisField.setAccessible(true);
                field.set(executable, thisField.get(this));
            }
        }
    }
}
