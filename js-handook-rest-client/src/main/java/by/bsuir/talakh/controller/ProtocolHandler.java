package by.bsuir.talakh.controller;

import by.bsuir.talakh.gui.TextConstant;

import java.util.HashMap;
import java.util.Map;

public class ProtocolHandler {
    private Map<String, Protocol> protocolMap;
    private Protocol currentProtocol;

    public ProtocolHandler() {
        protocolMap = new HashMap<>();

            protocolMap.put(TextConstant.REST, createRestProtocol());

        switchTo(TextConstant.REST);

    }

    public void switchTo(String protocolName) throws ProtocolException {
        currentProtocol = protocolMap.get(protocolName);
    }

    public Protocol getCurrentProtocol() {
        return currentProtocol;
    }


    private Protocol createRestProtocol() {
        return new RestProtocol();
    }



}
