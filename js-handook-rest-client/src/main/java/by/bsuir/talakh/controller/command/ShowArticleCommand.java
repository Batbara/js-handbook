package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.domain.JsObject;
import by.bsuir.talakh.domain.Method;
import by.bsuir.talakh.domain.Operator;
import by.bsuir.talakh.gui.ArticleView;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TextConstant;
import by.bsuir.talakh.gui.TreeComponent;
import org.apache.log4j.Logger;
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
       try{
            switch (methodToInvoke) {
                case TextConstant.OPERATOR_FIND_BY_NAME:

                    Operator operator = currentProtocol.findOperatorByName(itemName);
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
                case TextConstant.JS_OBJECT_FIND_BY_NAME:
                    JsObject jsObject = currentProtocol.findJsObjectByName(itemName);
                    String jsObjectDescription = jsObject.getDescription();
                    articleView.setArticle(jsObject);
                    articleView.setArticleText(jsObjectDescription);
                    break;
                case TextConstant.METHOD_FIND_BY_NAME:
                    Method method = currentProtocol.findMethodByName(itemName);
                    String methodDescription = method.getDescription();
                    articleView.setArticle(method);
                    articleView.setArticleText(methodDescription);
                    break;
            }
        } catch (ProtocolException e) {
            LOGGER.error("Error occurred", e);
        }
    }
}
