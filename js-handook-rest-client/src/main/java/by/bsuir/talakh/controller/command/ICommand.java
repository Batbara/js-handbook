package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ProtocolException;

public interface ICommand {
    void execute() throws ProtocolException;
}
