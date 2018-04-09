package by.bsuir.talakh.gui;

import by.bsuir.talakh.controller.ApplicationController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.Observable;

public class MainShell extends Observable {

    private ApplicationController controller;

    private Shell shell;
    private Display display;
    private TreeComponent treeComponent;
    private ArticleView articleView;
    private ControlButtonPanel controlButtonPanel;
    private AddJsObjectDialog addJsObjectDialog;
    private AddMethodDialog addMethodDialog;
    private AddOperatorDialog addOperatorDialog;
    private DeleteArticleDialog deleteArticleDialog;

    public MainShell(ApplicationController controller) {
        this.controller = controller;
        addObserver(controller);
        display = new Display();
        shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
        shell.setText(TextConstant.APP_TITLE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 3;
        shell.setLayout(gridLayout);
        treeComponent = new TreeComponent(this, controller);

        articleView = new ArticleView(this, controller);
        controlButtonPanel = new ControlButtonPanel(this, controller);
        addJsObjectDialog = new AddJsObjectDialog(this, controller);
        addMethodDialog = new AddMethodDialog(this, controller);
        addOperatorDialog = new AddOperatorDialog(this, controller);
        deleteArticleDialog = new DeleteArticleDialog(this, controller);

    }

    public void pack() {
        shell.pack();
    }

    public AddJsObjectDialog getAddJsObjectDialog() {
        return addJsObjectDialog;
    }

    public AddMethodDialog getAddMethodDialog() {
        return addMethodDialog;
    }

    public AddOperatorDialog getAddOperatorDialog() {
        return addOperatorDialog;
    }

    public DeleteArticleDialog getDeleteArticleDialog() {
        return deleteArticleDialog;
    }

    public TreeComponent getTreeComponent() {
        return treeComponent;
    }

    public ArticleView getArticleView() {
        return articleView;
    }

    public Shell getShell() {
        return shell;
    }


    public void start() {

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}
