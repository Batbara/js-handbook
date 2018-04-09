package by.bsuir.talakh.gui;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.AddJsObjectCommand;
import by.bsuir.talakh.controller.command.UpdateViewCommand;
import by.bsuir.talakh.domain.JsObjectAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;


public class AddJsObjectDialog extends AddArticleDialog {

    public AddJsObjectDialog(MainShell mainShell, ApplicationController controller) {
        super(mainShell, controller);
        dialog.setText(TextConstant.ADD_JS_OBJECT);
        Button addButton = new Button(dialog, SWT.PUSH);
        addButton.setText(TextConstant.ADD_JS_OBJECT);

        addButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                JsObjectAdapter jsObject = new JsObjectAdapter();
                String objectName = textMap.get(TextConstant.NAME_LABEL).getText();
                jsObject.setName(objectName);
                String objectDescription = textMap.get(TextConstant.DESCRIPTION_LABEL).getText();
                jsObject.setDescription(objectDescription);
                controller.update(mainShell, new AddJsObjectCommand(mainShell, controller, jsObject));
                dialog.setVisible(false);
                controller.update(mainShell, new UpdateViewCommand(mainShell, controller));

            }
        });
        dialog.pack();

    }




}
