package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.domain.OperatorAdapter;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import org.apache.thrift.TException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

public class AddOperatorCommand implements ICommand {
    private MainShell mainShell;
    private ApplicationController controller;
    private OperatorAdapter operator;

    public AddOperatorCommand(MainShell mainShell, ApplicationController controller, OperatorAdapter operator) {
        this.mainShell = mainShell;
        this.controller = controller;
        this.operator = operator;
    }

    @Override
    public void execute() throws ProtocolException {
        Protocol protocol = controller.getProtocolHandler().getCurrentProtocol();
        try {
            protocol.addOperator(operator);
            MessageBox infoMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_INFORMATION | SWT.OK);
            infoMessage.setText(TextConstant.ARTICLE_ADDED);
            infoMessage.setMessage("Operator " + operator.getOperatorSymbol() + " was successfully added!");
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
