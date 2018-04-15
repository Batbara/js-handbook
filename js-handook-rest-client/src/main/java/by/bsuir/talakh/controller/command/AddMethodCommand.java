package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.domain.Method;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

public class AddMethodCommand implements ICommand {
    private MainShell mainShell;
    private ApplicationController controller;
    private Method method;

    public AddMethodCommand(MainShell mainShell, ApplicationController controller, Method method) {
        this.mainShell = mainShell;
        this.controller = controller;
        this.method = method;
    }


    public void execute() throws ProtocolException {
        Protocol protocol = controller.getProtocolHandler().getCurrentProtocol();
        try {
            protocol.addMethod(method);
            MessageBox infoMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_INFORMATION | SWT.OK);
            infoMessage.setText(TextConstant.ARTICLE_ADDED);
            infoMessage.setMessage("Method '" + method.getName() + "' was successfully added!");
            infoMessage.open();
        } catch (ProtocolException e) {
            MessageBox errorMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_ERROR | SWT.OK);
            errorMessage.setText(TextConstant.ERROR_HEADER);
            errorMessage.setMessage("Article wasn't added: error occurred");
            errorMessage.open();
        }
    }
}
