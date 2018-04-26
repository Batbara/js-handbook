package by.bsuir.talakh.core;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, ICommand> commands = new HashMap<>();
    private static CommandProvider instance = new CommandProvider();

    private CommandProvider() {

    }

    public static CommandProvider getInstance() {
        return instance;
    }
    public ICommand getCommand(String name){
        return commands.get(name);
    }

}
