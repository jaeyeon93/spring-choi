package me.jimmy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationRunner {
    public static final Logger logger = LoggerFactory.getLogger(SampleListener.class);

    @Autowired
    private String hello;

    @Autowired
    private JimmyProperties jimmyProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("==============");
        logger.debug(hello);
        logger.debug(jimmyProperties.getName());
        logger.debug(jimmyProperties.getFulllName());
        logger.debug("==============");
    }

}
