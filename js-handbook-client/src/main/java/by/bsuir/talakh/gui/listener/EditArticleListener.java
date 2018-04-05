package by.bsuir.talakh.gui.listener;

import by.bsuir.talakh.gui.ArticleView;
import by.bsuir.talakh.gui.MainShell;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class EditArticleListener implements SelectionListener {
    private MainShell mainShell;

    public EditArticleListener(MainShell mainShell) {
        this.mainShell = mainShell;
    }

    @Override
    public void widgetSelected(SelectionEvent selectionEvent) {
        widgetDefaultSelected(selectionEvent);
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent selectionEvent) {
        ArticleView articleView = mainShell.getArticleView();
        articleView.setEditMode(true);
        articleView.setStashedText(articleView.getArticleText());
    }
}
