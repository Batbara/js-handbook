package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.gui.DeleteArticleDialog;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import by.bsuir.talakh.jsobject.JsObject;
import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.operator.Operator;
import org.apache.thrift.TException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;


public class DeleteArticleCommand implements ICommand {
    private MainShell mainShell;
    private ApplicationController controller;

    public DeleteArticleCommand(MainShell mainShell, ApplicationController controller) {
        this.mainShell = mainShell;
        this.controller = controller;
    }

    @Override
    public void execute() throws ProtocolException {
        Protocol protocol = controller.getProtocolHandler().getCurrentProtocol();
        DeleteArticleDialog dialog = mainShell.getDeleteArticleDialog();
        Object entity = dialog.getEntityToDelete();
        dialog.removeSelectedItem();
        try {
            if (entity instanceof JsObject) {
                protocol.deleteJsObject((JsObject) entity);
            } else if (entity instanceof Method) {
                protocol.deleteMethod((Method) entity);
            } else if (entity instanceof Operator) {
                protocol.deleteOperator((Operator) entity);
            }
            dialog.hideDialog();
            MessageBox infoMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_INFORMATION | SWT.OK);
            infoMessage.setText("Article deleted");
            infoMessage.setMessage("Article was successfully deleted!");
            infoMessage.open();

        } catch (TException e) {
            MessageBox errorMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_ERROR | SWT.OK);
            errorMessage.setText(TextConstant.ERROR_HEADER);
            errorMessage.setMessage("Article wasn't deleted: error occurred");
            errorMessage.open();

        }
    }
}
