package by.bsuir.talakh.controller;

import org.apache.log4j.BasicConfigurator;

public class Starter {
    public static void main(String... args) {
        /*BasicConfigurator.configure();
        ApplicationController controller = new ApplicationController();
        System.out.println("Красивый спиннер\n"+'2'+" лол");
        controller.startApplication();*/
        test();

    }
    static void test(){
        try{
            System.out.print(1);
            test();
            System.out.print(2);
        } finally {
            System.out.print(3);
            test();
            System.out.print(4);
        }
    }
}
