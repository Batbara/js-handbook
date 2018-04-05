package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.gui.AddMethodDialog;
import by.bsuir.talakh.gui.DeleteArticleDialog;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TreeComponent;
import by.bsuir.talakh.jsobject.JsObject;
import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.operator.Operator;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UpdateViewCommand implements ICommand {
    private MainShell mainShell;
    private Protocol protocol;

    public UpdateViewCommand(MainShell mainShell, ApplicationController controller) {
        this.mainShell = mainShell;
        this.protocol = controller.getProtocolHandler().getCurrentProtocol();
    }

    public void execute() throws ProtocolException {
        TreeComponent treeComponent = mainShell.getTreeComponent();
        treeComponent.clear();
        try {
            List<JsObject> jsObjects = protocol.takeJsObjectList();
            int objectCounter = 1;
            List<Method> allMethods = new ArrayList<>();
            for (JsObject jsObject : jsObjects) {
                treeComponent.addItemToObjectsTree(jsObject.getName(), 0);
                List<Method> jsObjectMethods = protocol.takeMethodList(jsObject);
                allMethods.addAll(jsObjectMethods);
                for (Method method : jsObjectMethods) {
                    treeComponent.addItemToObjectsTree(method.getName(), objectCounter);
                }
                objectCounter++;
            }

            List<Operator> operators = protocol.takeOperatorList();
            for (Operator operator : operators) {
                treeComponent.addItemToOperatorsTree(operator.getName(), 0);
            }
            AddMethodDialog addMethodDialog = mainShell.getAddMethodDialog();
            String[] jsObjectArray = jsObjects.stream().map(JsObject::getName).toArray(String[]::new);

            addMethodDialog.setComboItems(jsObjectArray);
            //  treeComponent.selectFirstTreeItem();
            DeleteArticleDialog deleteArticleDialog = mainShell.getDeleteArticleDialog();
            Map<String, Object> entityNameMap = convertToMap(jsObjects, allMethods, operators);
            deleteArticleDialog.setComboItemsMap(entityNameMap);

        } catch (TException e) {
            throw new ProtocolException("Protocol exception", e);
        }
    }


    private Map<String, Object> convertToMap(List<JsObject> jsObjects, List<Method> methods, List<Operator> operators) {
        Map<String, Object> jsObjectsMaps = jsObjects.stream().collect(Collectors.toMap(JsObject::getName, JsObject::new));
        Map<String, Object> methodsMap = methods.stream().collect(Collectors.toMap(Method::getName, Method::new));
        Map<String, Object> operatorsMap = operators.stream().collect(Collectors.toMap(Operator::getName, Operator::new));

        Map<String, Object> wholeMap = new LinkedHashMap<>();
        wholeMap.putAll(jsObjectsMaps);
        wholeMap.putAll(methodsMap);
        wholeMap.putAll(operatorsMap);

        return wholeMap;
    }

}
