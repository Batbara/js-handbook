package by.bsuir.talakh.gui;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.AddMethodCommand;
import by.bsuir.talakh.controller.command.UpdateViewCommand;
import by.bsuir.talakh.method.Method;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;


public class AddMethodDialog extends AddArticleDialog {
    private Combo combo;

    public AddMethodDialog(MainShell mainShell, ApplicationController controller) {
        super(mainShell, controller);
        dialog.setText(TextConstant.ADD_METHOD);
        Label chooseObjectLabel = new Label(dialog, SWT.NULL);
        chooseObjectLabel.setText(TextConstant.JS_OBJECT);
        combo = new Combo(dialog, SWT.NONE);
        combo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                super.widgetSelected(selectionEvent);
            }
        });
        Button addButton = new Button(dialog, SWT.PUSH);
        addButton.setText(TextConstant.ADD_METHOD);

        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                Method method = new Method();
                String methodName = textMap.get(TextConstant.NAME_LABEL).getText();
                method.setName(methodName);
                String methodDescription = textMap.get(TextConstant.DESCRIPTION_LABEL).getText();
                method.setDescription(methodDescription);
                String jsObjectName = combo.getText();
                method.setObjectName(jsObjectName);

                controller.update(mainShell, new AddMethodCommand(mainShell, controller, method));
                dialog.setVisible(false);
                controller.update(mainShell, new UpdateViewCommand(mainShell, controller));

            }
        });
        dialog.pack();
    }

    public void setComboItems(String[] comboItems) {
        combo.setItems(comboItems);
        combo.select(0);
    }
}
