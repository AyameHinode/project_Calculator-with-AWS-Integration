package com.repliforce.calculator;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String welcome = "Welcome %s to your Calculator!";
    private final AtomicLong idGenerator = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "") String name) {
        return new Greeting(idGenerator.incrementAndGet(), String.format(welcome, name));
    }

}
