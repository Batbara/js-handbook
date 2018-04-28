package by.bsuir.talakh.core.command;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, ICommand> commands = new HashMap<>();
    private static CommandProvider instance = new CommandProvider();

    private CommandProvider() {
        commands.put("take_js_object", new TakeJsObjectCmd());
        commands.put("take_method", new TakeMethodCmd());
        commands.put("take_operator", new TakeOperatorCmd());

        commands.put("add_js_object", new AddJsObjectCmd());
        commands.put("add_method", new AddMethodCmd());
        commands.put("add_operator", new AddOperatorCmd());


        commands.put("update_js_object", new UpdateJsObjectCmd());
        commands.put("update_method", new UpdateMethodCmd());
        commands.put("update_operator", new UpdateOperatorCmd());


        commands.put("delete_js_object", new DeleteJsObjectCmd());
        commands.put("delete_method", new DeleteMethodCmd());
        commands.put("delete_operator", new DeleteOperatorCmd());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public ICommand getCommand(String name) {
        return commands.get(name);
    }

}
