package by.bsuir.talakh.gui;


import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolHandler;
import by.bsuir.talakh.controller.command.UpdateViewCommand;
import by.bsuir.talakh.gui.listener.EditArticleListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import java.util.Observable;

public class ControlButtonPanel extends Observable {
    private ApplicationController controller;

    private Composite holder;
    private MainShell mainShell;
    private Button updateButton;


    public ControlButtonPanel(MainShell mainShell, ApplicationController controller) {
        this.controller = controller;
        this.mainShell = mainShell;
        holder = new Composite(mainShell.getShell(), SWT.NONE);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.justify = true;
        rowLayout.center = true;
        rowLayout.spacing = 10;
        holder.setLayout(rowLayout);
        initButtons();
    }

    private void initButtons() {
        Group radioButtonsGroup = new Group(holder, SWT.NONE);
        radioButtonsGroup.setLayout(new RowLayout(SWT.VERTICAL));

        Button rpcButton = new Button(radioButtonsGroup, SWT.RADIO);
        rpcButton.setText(TextConstant.RPC);
        rpcButton.setSelection(true);

        Button soapButton = new Button(radioButtonsGroup, SWT.RADIO);
        soapButton.setText(TextConstant.SOAP);

        radioButtonsGroup.setText(TextConstant.PROTOCOL);

        Button addJsObjectButton = new Button(holder, SWT.PUSH);
        addJsObjectButton.setText(TextConstant.ADD_JS_OBJECT);
        addJsObjectButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                AddArticleDialog addDialog = mainShell.getAddJsObjectDialog();
                addDialog.clearTextFields();
                addDialog.open();
            }
        });

        Button addMethodButton = new Button(holder, SWT.PUSH);
        addMethodButton.setText(TextConstant.ADD_METHOD);
        addMethodButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                AddArticleDialog addDialog = mainShell.getAddMethodDialog();
                addDialog.clearTextFields();
                addDialog.open();
            }
        });

        Button addOperatorButton = new Button(holder, SWT.PUSH);
        addOperatorButton.setText(TextConstant.ADD_OPERATOR);
        addOperatorButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                AddArticleDialog addDialog = mainShell.getAddOperatorDialog();
                addDialog.clearTextFields();
                addDialog.open();
            }
        });

        Button deleteButton = new Button(holder, SWT.PUSH);
        deleteButton.setText(TextConstant.DELETE_BUTTON);
        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                DeleteArticleDialog deleteArticleDialog = mainShell.getDeleteArticleDialog();
                deleteArticleDialog.open();
            }
        });

        Button editButton = new Button(holder, SWT.PUSH);
        editButton.setText(TextConstant.EDIT_BUTTON);
        editButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                ArticleView articleView = mainShell.getArticleView();
                articleView.setEditMode(true);
                articleView.setStashedText(articleView.getArticleText());
            }
        });

        updateButton = new Button(holder, SWT.PUSH);
        updateButton.setText(TextConstant.UPDATE_BUTTON);
        updateButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                controller.update(mainShell, new UpdateViewCommand(mainShell, controller));
            }
        });

    }

    public Button getUpdateButton() {
        return updateButton;
    }


}
