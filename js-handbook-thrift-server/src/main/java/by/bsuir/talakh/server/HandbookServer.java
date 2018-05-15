package by.bsuir.talakh.server;

import by.bsuir.talakh.dao.JsObjectDao;
import by.bsuir.talakh.dao.MethodDao;
import by.bsuir.talakh.dao.OperatorDao;
import by.bsuir.talakh.jsobject.JsObjectService;
import by.bsuir.talakh.method.MethodService;
import by.bsuir.talakh.operator.OperatorService;
import org.apache.log4j.Logger;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class HandbookServer implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(HandbookServer.class);

    public void run() {
        try {
            LOGGER.info("Initializing server");
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            processor.registerProcessor(
                    "Method",
                    new MethodService.Processor<MethodDao>(new MethodDao()));

            processor.registerProcessor(
                    "JsObject",
                    new JsObjectService.Processor<JsObjectDao>(new JsObjectDao()));

            processor.registerProcessor(
                    "Operator",
                    new OperatorService.Processor<OperatorDao>(new OperatorDao()));

            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            server.serve();
        } catch (TTransportException e) {
            LOGGER.error("Transport error occurred", e);
        }
    }
}
