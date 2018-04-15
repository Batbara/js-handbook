package by.bsuir.talakh.controller;

import org.apache.log4j.BasicConfigurator;

public class Starter {
    public static void main(String... args) {
        BasicConfigurator.configure();
        ApplicationController controller = new ApplicationController();
        controller.startApplication();

    }
}
