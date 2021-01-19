package Lesson6;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public void sayHello() {
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        LOG.info("INFO");
        LOG.debug("DEBUG");
        int x = 3;
        LOG.debug("x = {}, list = {}", x, List.of("123"));
    }
}
