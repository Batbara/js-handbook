package by.bsuir.talakh.gui;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.DeleteArticleCommand;
import by.bsuir.talakh.controller.command.UpdateViewCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DeleteArticleDialog {
    private MainShell mainShell;
    private ApplicationController controller;

    private Shell dialog;
    private Combo combo;
    private Map<String, Object> comboItemsMap;
    private static final String CAPTION = "Choose article to delete";

    public DeleteArticleDialog(MainShell mainShell, ApplicationController controller) {
        this.controller = controller;
        this.mainShell = mainShell;
        comboItemsMap = new HashMap<>();
        initDialogWindow();

        dialog.addListener(SWT.Close, event -> {
            event.doit=false;
            dialog.setVisible(false);
        });

    }

    public void open() {
        dialog.open();
    }

    public void removeSelectedItem() {
        comboItemsMap.remove(combo.getText());
        setComboItems();

    }

    public Object getEntityToDelete() {
        String entityName = combo.getText();
        return comboItemsMap.get(entityName);
    }

    public void setComboItemsMap(Map<String, Object> comboItemsMap) {
        this.comboItemsMap = comboItemsMap;
        setComboItems();
    }
    public void hideDialog(){
        dialog.setVisible(false);
    }
    private void initDialogWindow() {
        dialog = new Shell(mainShell.getShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.ON_TOP);
        dialog.setText(TextConstant.DELETE_BUTTON);
        dialog.setLayout(new RowLayout(SWT.VERTICAL));
        Label caption = new Label(dialog, SWT.NONE);
        caption.setText(CAPTION);
        combo = new Combo(dialog, SWT.READ_ONLY);
        Button deleteButton = new Button(dialog, SWT.PUSH);
        deleteButton.setText("Delete");
        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                controller.update(mainShell, new DeleteArticleCommand(mainShell, controller));
                controller.update(mainShell, new UpdateViewCommand(mainShell, controller));
                dialog.setVisible(false);
            }
        });
        dialog.pack();
    }

    private void setComboItems() {
        Set<String> comboItemsSet = comboItemsMap.keySet();
        String[] comboItemsArray = comboItemsSet.toArray(new String[0]);
        combo.setItems(comboItemsArray);
        combo.select(0);
    }
}
