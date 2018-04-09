package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.controller.ProtocolHandler;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

public class ChangeProtocolCommand implements ICommand {
    private ApplicationController controller;
    private MainShell mainShell;
    private String protocolName;

    public ChangeProtocolCommand(ApplicationController controller, MainShell mainShell, String protocolName) {
        this.controller = controller;
        this.mainShell = mainShell;
        this.protocolName = protocolName;
    }

    @Override
    public void execute() throws ProtocolException {
        ProtocolHandler protocolHandler = controller.getProtocolHandler();
        try {
            protocolHandler.switchTo(protocolName);
            MessageBox infoMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_INFORMATION | SWT.OK);
            infoMessage.setText(TextConstant.PROTOCOL_SWITCHED);
            infoMessage.setMessage("Switched to " + protocolName + " protocol successfully!");
            infoMessage.open();
        } catch (ProtocolException e) {
            MessageBox errorMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_ERROR | SWT.OK);
            errorMessage.setText(TextConstant.ERROR_HEADER);
            errorMessage.setMessage("Cannot switch protocol to " + protocolName);
            errorMessage.open();
        }
    }
}
