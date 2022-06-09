package de.borisskert.springbootsleuthexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @RequestMapping("/greeting")
    public String greeting() {
        LOGGER.info("Handling home");
        return "Hello World";
    }
}
