package by.bsuir.talakh.controller.command;

import by.bsuir.talakh.controller.ApplicationController;
import by.bsuir.talakh.controller.Protocol;
import by.bsuir.talakh.controller.ProtocolException;
import by.bsuir.talakh.domain.JsObjectAdapter;
import by.bsuir.talakh.domain.MethodAdapter;
import by.bsuir.talakh.domain.OperatorAdapter;
import by.bsuir.talakh.gui.AddMethodDialog;
import by.bsuir.talakh.gui.DeleteArticleDialog;
import by.bsuir.talakh.gui.MainShell;
import by.bsuir.talakh.gui.TreeComponent;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
            List<JsObjectAdapter> jsObjects = protocol.takeJsObjectList();
            int objectCounter = 1;
            List<MethodAdapter> allMethods = new ArrayList<>();
            for (JsObjectAdapter jsObject : jsObjects) {
                treeComponent.addItemToObjectsTree(jsObject.getName(), 0);
                List<MethodAdapter> jsObjectMethods = protocol.takeMethodList(jsObject);
                allMethods.addAll(jsObjectMethods);
                for (MethodAdapter method : jsObjectMethods) {
                    treeComponent.addItemToObjectsTree(method.getName(), objectCounter);
                }
                objectCounter++;
            }

            List<OperatorAdapter> operators = protocol.takeOperatorList();
            for (OperatorAdapter operator : operators) {
                treeComponent.addItemToOperatorsTree(operator.getName(), 0);
            }
            AddMethodDialog addMethodDialog = mainShell.getAddMethodDialog();
            String[] jsObjectArray = jsObjects.stream().map(JsObjectAdapter::getName).toArray(String[]::new);

            addMethodDialog.setComboItems(jsObjectArray);
            DeleteArticleDialog deleteArticleDialog = mainShell.getDeleteArticleDialog();
            Map<String, Object> entityNameMap = convertToMap(jsObjects, allMethods, operators);
            deleteArticleDialog.setComboItemsMap(entityNameMap);

        } catch (TException e) {
            throw new ProtocolException("Protocol exception", e);
        }
    }


    private Map<String, Object> convertToMap(List<JsObjectAdapter> jsObjects,
                                             List<MethodAdapter> methods,
                                             List<OperatorAdapter> operators) {
        Map<String, Object> jsObjectsMaps = jsObjects.stream()
                .collect(Collectors.toMap(JsObjectAdapter::getName, Function.identity()));
        Map<String, Object> methodsMap = methods.stream()
                .collect(Collectors.toMap(MethodAdapter::getName, Function.identity()));
        Map<String, Object> operatorsMap = operators.stream()
                .collect(Collectors.toMap(OperatorAdapter::getName, Function.identity()));

        Map<String, Object> wholeMap = new LinkedHashMap<>();
        wholeMap.putAll(jsObjectsMaps);
        wholeMap.putAll(methodsMap);
        wholeMap.putAll(operatorsMap);

        return wholeMap;
    }

}
