package tr.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class FirstServiceController {
    Logger logger = LogManager.getLogger(FirstServiceController.class);

    @Autowired
    Environment environment;

    @GetMapping("/getVal")
    public String getVal1(){
        logger.info("Val ");
        return environment.getProperty("value1") + " " + environment.getProperty("local.server.port");
    }
}
