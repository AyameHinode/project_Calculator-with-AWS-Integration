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
            @PathVariable(value = "number2") String number2)
    throws Exception{
        if (!isNumeric(number1) || !isNumeric(number2)){
            throw new Exception();
        }
        return convertToDouble(number1) + convertToDouble(number2);
    }

    private Double convertToDouble(String stringNumber) {
        return null;
    }

    private boolean isNumeric(String StringNumber) {
        return false;
    }

}
