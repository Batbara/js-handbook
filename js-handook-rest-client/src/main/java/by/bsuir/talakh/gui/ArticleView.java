package by.bsuir.talakh.gui;


import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.EditArticleCommand;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;


public class ArticleView {
    private Composite holder;
    private StyledText textMemo;
    private Color DEFAULT_COLOR = new Color(Display.getCurrent(), 200, 230, 232);

    private Color EDIT_COLOR = new Color(Display.getCurrent(), 255, 243, 201);
    private Composite buttonHolder;
    private MainShell mainShell;
    private String stashedText;
    private Object article;

    public ArticleView(MainShell mainShell, ApplicationController controller) {
        this.mainShell = mainShell;
        holder = new Composite(mainShell.getShell(), SWT.FILL | SWT.WRAP);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL | SWT.RIGHT);
        rowLayout.spacing = 10;
        holder.setLayout(rowLayout);

        Point size = new Point(450, 50);
        holder.setSize(size);
        final int padding = 10;

        textMemo = new StyledText(holder, SWT.LEFT | SWT.WRAP | SWT.V_SCROLL);

        textMemo.setLeftMargin(padding);
        textMemo.setRightMargin(padding);
        textMemo.setTopMargin(padding);
        textMemo.setBottomMargin(padding);
        textMemo.setEditable(false);
        // textMemo.setWordWrap(true);
        // textMemo.setCaret(null);
        textMemo.setFont(new Font(Display.getCurrent(), "Helvetica", 12, SWT.SIMPLE));
        textMemo.setBackground(DEFAULT_COLOR);
        textMemo.setLayoutData(new RowData(350, 320));
        //  textMemo.setSize(420,200);

        buttonHolder = new Composite(holder, SWT.RIGHT);
        buttonHolder.setVisible(false);
        buttonHolder.setBackground(DEFAULT_COLOR);
        buttonHolder.setLayout(new RowLayout());
        Button sendButton = new Button(buttonHolder, SWT.PUSH);
        sendButton.setText("OK");
        sendButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                controller.update(mainShell, new EditArticleCommand(mainShell, controller));
            }
        });
        Button cancelButton = new Button(buttonHolder, SWT.PUSH);
        cancelButton.setText("Cancel");
        //  cancelButton.setVisible(false);
        cancelButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                setEditMode(false);
                setArticleText(stashedText);
            }
        });
    }

    public void setArticle(Object article) {
        this.article = article;
    }

    public Object getArticle() {
        return article;
    }

    public String getStashedText() {
        return stashedText;
    }

    public void setStashedText(String stashedText) {
        this.stashedText = stashedText;
    }

    public void setArticleText(String text) {
        text = StringEscapeUtils.unescapeJava(text);
        textMemo.setText(text);
    }

    public String getArticleText() {
        return textMemo.getText();
    }

    public void setEditMode(boolean isEditing) {
        textMemo.setEditable(isEditing);
        if (isEditing) {
            textMemo.setBackground(EDIT_COLOR);
            textMemo.setFocus();
            holder.setBackground(new Color(Display.getCurrent(), 200, 230, 232));
            buttonHolder.setVisible(true);
        } else {
            textMemo.setEditable(false);
            textMemo.setBackground(DEFAULT_COLOR);
            buttonHolder.setVisible(false);
        }
    }

}
