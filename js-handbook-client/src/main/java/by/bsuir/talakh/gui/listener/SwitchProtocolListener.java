package by.bsuir.talakh.gui.listener;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.ChangeProtocolCommand;
import by.bsuir.talakh.gui.MainShell;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;


public class SwitchProtocolListener implements SelectionListener {
    private ApplicationController controller;
    private MainShell mainShell;

    public SwitchProtocolListener(ApplicationController controller, MainShell mainShell) {
        this.controller = controller;
        this.mainShell = mainShell;
    }

    @Override
    public void widgetSelected(SelectionEvent selectionEvent) {
        Button button = (Button) selectionEvent.widget;
        if (button.getSelection()) {
            controller.update(mainShell, new ChangeProtocolCommand(controller, mainShell, button.getText()));
        }
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent selectionEvent) {

    }
}
