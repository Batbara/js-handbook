package by.bsuir.talakh.gui;

import by.bsuir.talakh.controller.ApplicationController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.HashMap;
import java.util.Map;

public class AddArticleDialog {
    protected ApplicationController controller;
    protected MainShell mainShell;
    protected Shell dialog;

    protected Map<String, Text> textMap = new HashMap<>();

    public AddArticleDialog() {
    }

    public AddArticleDialog(MainShell mainShell, ApplicationController controller) {
        this.mainShell = mainShell;
        this.controller = controller;
        initDialogWindow();

    }
    public void clearTextFields() {
        for (Text text : textMap.values()) {
            text.setText("");
        }
    }
    public void open() {
        dialog.open();
    }

    private void initDialogWindow() {
        dialog = new Shell(mainShell.getShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.ON_TOP);
        dialog.setLayout(new RowLayout(SWT.VERTICAL));
        dialog.setText(TextConstant.ADD_BUTTON);
        dialog.addListener(SWT.Close, event -> {
            event.doit=false;
            dialog.setVisible(false);
        });
        placeComponents();
        dialog.pack();
    }

    private void placeComponents() {


        Label nameLabel = new Label(dialog, SWT.NULL);
        nameLabel.setText(TextConstant.NAME_LABEL);
        Text nameText = new Text(dialog, SWT.SINGLE | SWT.BORDER | SWT.MULTI);
        textMap.put(TextConstant.NAME_LABEL, nameText);


        Label descriptionLabel = new Label(dialog, SWT.NULL);
        descriptionLabel.setText(TextConstant.DESCRIPTION_LABEL);

        Text descriptionText = new Text(dialog, SWT.SINGLE | SWT.BORDER);
        textMap.put(TextConstant.DESCRIPTION_LABEL, descriptionText);


    }

}
