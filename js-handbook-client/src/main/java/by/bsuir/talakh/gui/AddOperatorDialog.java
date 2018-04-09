package by.bsuir.talakh.gui;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.AddOperatorCommand;
import by.bsuir.talakh.controller.command.UpdateViewCommand;
import by.bsuir.talakh.domain.OperatorAdapter;
import by.bsuir.talakh.operator.Operator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class AddOperatorDialog extends AddArticleDialog {

    public AddOperatorDialog(MainShell mainShell, ApplicationController controller) {
        super(mainShell, controller);
        dialog.setText(TextConstant.ADD_OPERATOR);
        Label operatorSymbol = new Label(dialog, SWT.NULL);
        operatorSymbol.setText(TextConstant.SYMBOL);

        Text symbolText = new Text(dialog, SWT.SINGLE | SWT.BORDER | SWT.MULTI);

        Button addButton = new Button(dialog, SWT.PUSH);
        addButton.setText(TextConstant.ADD_OPERATOR);

        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                OperatorAdapter operator = new OperatorAdapter();

                String operatorName = textMap.get(TextConstant.NAME_LABEL).getText();
                operator.setName(operatorName);
                String operatorDescription = textMap.get(TextConstant.DESCRIPTION_LABEL).getText();
                operator.setDescription(operatorDescription);
                operator.setOperatorSymbol(symbolText.getText());

                controller.update(mainShell, new AddOperatorCommand(mainShell, controller, operator));
                dialog.setVisible(false);
                controller.update(mainShell, new UpdateViewCommand(mainShell, controller));

            }
        });
        dialog.pack();
    }
}
