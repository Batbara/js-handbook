package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.domain.JsObjectAdapter;
import by.bsuir.talakh.domain.MethodAdapter;
import by.bsuir.talakh.domain.OperatorAdapter;
import by.bsuir.talakh.gui.ArticleView;
import by.bsuir.talakh.gui.MainShell;
import org.apache.thrift.TException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

public class EditArticleCommand implements ICommand {
    private MainShell mainShell;
    private ApplicationController controller;

    public EditArticleCommand(MainShell mainShell, ApplicationController applicationController) {
        this.mainShell = mainShell;
        this.controller = applicationController;
    }

    @Override
    public void execute() throws ProtocolException {
        Protocol protocol = controller.getProtocolHandler().getCurrentProtocol();
        ArticleView articleView = mainShell.getArticleView();
        Object article = articleView.getArticle();
        try {
            if (article instanceof JsObjectAdapter) {
                JsObjectAdapter jsObject = (JsObjectAdapter) article;
                jsObject.setDescription(articleView.getArticleText());
                protocol.updateJsObject(jsObject);
            } else if (article instanceof MethodAdapter) {
                MethodAdapter method = (MethodAdapter) article;
                method.setDescription(articleView.getArticleText());
                protocol.updateMethod(method);
            } else if (article instanceof OperatorAdapter) {
                OperatorAdapter operator = (OperatorAdapter) article;
                operator.setDescription(articleView.getArticleText());
                protocol.updateOperator(operator);
            }
            articleView.setEditMode(false);
            MessageBox infoMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_INFORMATION | SWT.OK);
            infoMessage.setText("Article updated");
            infoMessage.setMessage("Article was successfully updated!");
            infoMessage.open();

        } catch (TException e) {
            articleView.setEditMode(false);
            MessageBox errorMessage = new MessageBox(mainShell.getShell(),
                    SWT.ICON_ERROR | SWT.OK);
            errorMessage.setText("Something went wrong..");
            errorMessage.setMessage("Article wasn't updated: error occurred");
            errorMessage.open();

        }
    }
}
