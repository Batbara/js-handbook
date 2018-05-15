package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.domain.JsObjectAdapter;
import by.bsuir.talakh.domain.MethodAdapter;
import by.bsuir.talakh.domain.OperatorAdapter;
import by.bsuir.talakh.gui.ArticleView;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import by.bsuir.talakh.gui.TreeComponent;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.eclipse.swt.widgets.TreeItem;

public class ShowArticleCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(ShowArticleCommand.class);
    private MainShell mainShell;
    private TreeItem selectedItem;
    private ApplicationController controller;

    public ShowArticleCommand(MainShell mainShell, ApplicationController controller, TreeItem selectedItem) {
        this.mainShell = mainShell;
        this.selectedItem = selectedItem;
        this.controller = controller;
    }

    @Override
    public void execute() throws ProtocolException {
        Protocol currentProtocol = controller.getProtocolHandler().getCurrentProtocol();

        TreeComponent treeComponent = mainShell.getTreeComponent();
        String itemName = selectedItem.getText();
        String methodToInvoke = treeComponent.takeMethodNameForItem(itemName);
        ArticleView articleView = mainShell.getArticleView();
        try {
            switch (methodToInvoke) {
                case TextConstant.OPERATOR_FIND_BY_NAME:

                    OperatorAdapter operator = currentProtocol.findOperatorByName(itemName);
                    String operatorSymbol = "Symbol: " + operator.getOperatorSymbol() + "\n\n";
                    String operatorDescription;
                    if (operator.getDescription().contains(operatorSymbol)) {
                        operatorDescription = operator.getDescription();
                    } else {
                        operatorDescription = operatorSymbol + operator.getDescription();
                    }
                    articleView.setArticle(operator);
                    articleView.setArticleText(operatorDescription);
                    break;
                case TextConstant.JSOBJECT_FIND_BY_NAME:
                    JsObjectAdapter jsObject = currentProtocol.findJsObjectByName(itemName);
                    String jsObjectDescription = jsObject.getDescription();
                    articleView.setArticle(jsObject);
                    articleView.setArticleText(jsObjectDescription);
                    break;
                case TextConstant.METHOD_FIND_BY_NAME:
                    MethodAdapter method = currentProtocol.findMethodByName(itemName);
                    String methodDescription = method.getDescription();
                    articleView.setArticle(method);
                    articleView.setArticleText(methodDescription);
                    break;
            }
        } catch (TException e) {
            LOGGER.error("Error occurred", e);
        }
    }
}
