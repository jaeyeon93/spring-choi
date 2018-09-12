package me.jimmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationRunner {

    @Autowired
    private String hello;

    @Autowired
    private JimmyProperties jimmyProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============");
        System.out.println(hello);
        System.out.println(jimmyProperties.getName());
        System.out.println(jimmyProperties.getFulllName());
        System.out.println("==============");
    }

}
