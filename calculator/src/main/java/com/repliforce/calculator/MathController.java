package com.repliforce.calculator;



import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong idGenerator = new AtomicLong();

    @RequestMapping(value = "/sum/{number1}/{number2}",
        method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2) {
        return 1D;
    }

}
