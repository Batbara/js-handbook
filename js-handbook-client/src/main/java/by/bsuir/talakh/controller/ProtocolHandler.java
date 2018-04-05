package by.bsuir.talakh.controller;

import by.bsuir.talakh.gui.TextConstant;
import by.bsuir.talakh.jsobject.JsObjectService;
import by.bsuir.talakh.method.MethodService;
import by.bsuir.talakh.operator.OperatorService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.HashMap;
import java.util.Map;

public class ProtocolHandler {
    private Map<String, Protocol> protocolMap;
    private Protocol currentProtocol;

    public ProtocolHandler() {
        protocolMap = new HashMap<String, Protocol>();
        protocolMap.put(TextConstant.RPC, new RpcProtocol());
        initHandler();

    }

    public void initHandler() throws ProtocolException {

        switchTo(TextConstant.RPC);

    }


    public void switchTo(String protocolName) throws ProtocolException {
        if (protocolName.equals(TextConstant.RPC)) {
            try {
                switchToRpc();
            } catch (TTransportException e) {
                throw new ProtocolException("Error with RPC", e);
            }
        } else {
            throw new ProtocolException(protocolName + " unknown protocol name");
        }
    }

    public Protocol getCurrentProtocol() {
        return currentProtocol;
    }

    private void switchToRpc() throws TTransportException {
        TSocket transport = new TSocket("localhost", 9090);
        transport.open();

        TBinaryProtocol thriftProtocol = new TBinaryProtocol(transport);

        MethodService.Client methodService = new MethodService.Client
                (new TMultiplexedProtocol(thriftProtocol, "Method"));
        JsObjectService.Client jsObjectService = new JsObjectService.Client(
                new TMultiplexedProtocol(thriftProtocol, "JsObject"));
        OperatorService.Client operatorService = new OperatorService.Client(
                new TMultiplexedProtocol(thriftProtocol, "Operator"));

        this.currentProtocol = new RpcProtocol(methodService, jsObjectService, operatorService);
    }


}
