package by.bsuir.talakh.server;

import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.method.MethodService;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.junit.Test;

import java.util.List;

public class ServerTest {
    private final Logger LOGGER = Logger.getLogger(ServerTest.class);
    @Test
    public void testRetrieveAllMethods() throws TException {
        ServerStarter.main(new String[2]);

        TSocket transport = new TSocket("localhost", 9090);
        transport.open();

        TBinaryProtocol protocol = new TBinaryProtocol(transport);

        TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, "Method");
        MethodService.Client service = new MethodService.Client(mp);

        //List<Method> methodList = service.takeAll();
       // LOGGER.info(methodList);
    }
}
