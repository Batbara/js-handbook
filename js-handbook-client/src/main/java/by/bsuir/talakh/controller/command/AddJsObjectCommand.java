package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import by.bsuir.talakh.jsobject.JsObject;
import org.apache.thrift.TException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

public class AddJsObjectCommand implements ICommand {
    private JsObject jsObject;
    private MainShell mainShell;
    private ApplicationController controller;

    public AddJsObjectCommand(MainShell mainShell, ApplicationController controller, JsObject jsObject) {
        this.jsObject = jsObject;
        this.mainShell = mainShell;
        this.controller = controller;
    }

    @Override
    public void execute() throws ProtocolException {
        Protocol protocol = controller.getProtocolHandler().getCurrentProtocol();
        try {
            protocol.addJsObject(jsObject);
            MessageBox infoMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_INFORMATION | SWT.OK);
            infoMessage.setText(TextConstant.ARTICLE_ADDED);
            infoMessage.setMessage("JS object '" + jsObject.getName() + "' was successfully added!");
            infoMessage.open();
        } catch (TException e) {
            MessageBox errorMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_ERROR | SWT.OK);
            errorMessage.setText(TextConstant.ERROR_HEADER);
            errorMessage.setMessage("Article wasn't added: error occurred");
            errorMessage.open();
        }
    }
}
