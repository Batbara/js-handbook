package by.bsuir.talakh.server;

import org.apache.log4j.BasicConfigurator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerStarter {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        threadExecutor.execute(new HandbookServer());
    }
}
