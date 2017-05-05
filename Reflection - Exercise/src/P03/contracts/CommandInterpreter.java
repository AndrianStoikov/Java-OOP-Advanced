package P03.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
