package by.bsuir.talakh.gui;


import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.command.ShowArticleCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import java.util.HashMap;
import java.util.Map;


public class TreeComponent {
    private final static String JS_OBJECT_HEADER = "JS objects";
    private final static String OPERATOR_HEADER = "Operators";
    private Composite holder;
    private Tree objectsTree;
    private Tree operatorsTree;
    private Map<String, String> methodMap;

    public TreeComponent(MainShell mainShell, ApplicationController controller) {
        methodMap = new HashMap<>();
        holder = new Composite(mainShell.getShell(), SWT.NO_BACKGROUND);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.justify = true;

        holder.setLayout(rowLayout);

        objectsTree = new Tree(holder, SWT.SINGLE | SWT.BORDER);
        objectsTree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                TreeItem selectedItem = (TreeItem) selectionEvent.item;
                controller.update(mainShell, new ShowArticleCommand(mainShell, controller, selectedItem));
            }
        });
        TreeColumn column = new TreeColumn(objectsTree, SWT.LEFT);
        column.setResizable(false);
        column.setWidth(150);
        objectsTree.setHeaderVisible(true);

        column.setText(JS_OBJECT_HEADER);

        operatorsTree = new Tree(holder, SWT.SINGLE | SWT.BORDER);
        operatorsTree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                TreeItem selectedItem = (TreeItem) selectionEvent.item;
                controller.update(mainShell, new ShowArticleCommand(mainShell, controller, selectedItem));

            }
        });
        operatorsTree.setSize(150, 550);
        TreeColumn operatorsColumn = new TreeColumn(operatorsTree, SWT.LEFT);
        operatorsColumn.setResizable(false);
        operatorsColumn.setWidth(150);
        operatorsTree.setHeaderVisible(true);

        operatorsColumn.setText(OPERATOR_HEADER);
    }

    public void selectFirstTreeItem() {

        TreeItem firstObjectItem = objectsTree.getItem(0);
        objectsTree.showItem(firstObjectItem);
    }

    public void clear() {
        if (operatorsTree.getItemCount() != 0) {
            disposeItems(operatorsTree.getItems());
        }
        if (objectsTree.getItemCount() != 0) {
            disposeItems(objectsTree.getItems());
        }
    }

    public void addItemToObjectsTree(String itemText, int level) {
        if (level == 0) {
            methodMap.put(itemText, TextConstant.JSOBJECT_FIND_BY_NAME);
        } else {
            methodMap.put(itemText, TextConstant.METHOD_FIND_BY_NAME);
        }
        addItemToTree(objectsTree, itemText, level);
    }

    public void addItemToOperatorsTree(String itemText, int level) {
        methodMap.put(itemText, TextConstant.OPERATOR_FIND_BY_NAME);
        addItemToTree(operatorsTree, itemText, level);
    }

    public String takeMethodNameForItem(String itemText) {
        return methodMap.get(itemText);
    }

    private void addItemToTree(Tree tree, String itemText, int level) {
        TreeItem treeItem;
        if (level == 0) {
            treeItem = new TreeItem(tree, SWT.NONE);
        } else {
            TreeItem parent = tree.getItem(level - 1);
            treeItem = new TreeItem(parent, SWT.NONE, 0);
        }
        treeItem.setText(itemText);
    }

    private void disposeItems(TreeItem[] treeItems) {
        for (TreeItem item : treeItems) {
            item.dispose();
        }
    }
}
