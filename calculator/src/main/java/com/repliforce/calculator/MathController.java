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
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return convertToDouble(number1) + convertToDouble(number2);
    }

    @RequestMapping(value = "/sub/{number1}/{number2}",
            method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception{
        if (!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return convertToDouble(number1) - convertToDouble(number2);
    }

    @RequestMapping(value = "/mul/{number1}/{number2}",
            method = RequestMethod.GET)
    public Double mul(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception{
        if (!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return convertToDouble(number1) * convertToDouble(number2);
    }

    @RequestMapping(value = "/div/{number1}/{number2}",
            method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception{
        if (!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return convertToDouble(number1) / convertToDouble(number2);
    }

    @RequestMapping(value = "/mean/{number1}/{number2}",
            method = RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
            throws Exception{
        if (!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return (convertToDouble(number1) + convertToDouble(number2))/2;
    }

    @RequestMapping(value = "/sqrt/{number1}",
            method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number1") String number1)
            throws Exception{
        if (!isNumeric(number1)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return Math.sqrt(convertToDouble(number1));
    }

    private Double convertToDouble(String stringNumber) {
        if (stringNumber == null) return 0D;
        String number = stringNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String stringNumber) {
        if (stringNumber == null) return false;
        String number = stringNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
