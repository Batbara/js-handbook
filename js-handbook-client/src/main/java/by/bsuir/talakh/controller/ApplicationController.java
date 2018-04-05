package by.bsuir.talakh.controller;

import by.bsuir.talakh.controller.command.ICommand;
import by.bsuir.talakh.controller.command.UpdateViewCommand;
import by.bsuir.talakh.gui.MainShell;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import java.util.Observable;
import java.util.Observer;

public class ApplicationController implements Observer {

    private MainShell mainShell;
    private ProtocolHandler protocolHandler;
    private final Logger LOGGER = Logger.getLogger(ApplicationController.class);

    public ApplicationController() {

        try {
            protocolHandler = new ProtocolHandler();
            mainShell = new MainShell(this);

            UpdateViewCommand updateViewCommand = new UpdateViewCommand(mainShell, this);

            updateViewCommand.execute();
            mainShell.pack();
            mainShell.addObserver(this);
        } catch (ProtocolException e) {
            LOGGER.error("Cannot init protocol handler", e);
            MessageBox fatalError = new MessageBox(new Shell(new Display()), SWT.ICON_ERROR | SWT.OK);
            fatalError.setText("Server error!");
            fatalError.setMessage("Cannot start the application :(");
            int buttonID = fatalError.open();
            switch(buttonID) {
                case SWT.OK:
                    System.exit(-1);
            }
        }


    }


    public void startApplication() {
        mainShell.start();
    }

    public void update(Observable o, Object arg) {
        ICommand command = (ICommand) arg;
        try {
            command.execute();
        } catch (ProtocolException e) {
            LOGGER.error("Cannot update GUI", e);
        }
    }

    public ProtocolHandler getProtocolHandler() {
        return protocolHandler;
    }

    public void setProtocolHandler(ProtocolHandler protocolHandler) {
        this.protocolHandler = protocolHandler;
    }
}
