package com.repliforce.calculator.controllers;



import com.repliforce.calculator.math.BasicOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.repliforce.calculator.converters.NumberConverters.convertToDouble;
import static com.repliforce.calculator.converters.NumberConverters.isNumeric;

@RestController
public class MathController {
    private final AtomicLong idGenerator = new AtomicLong();

    private BasicOperations basicOperations = new BasicOperations();

    @RequestMapping(value = "/sum/{number1}/{number2}",
        method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "number1") String number1,
            @PathVariable(value = "number2") String number2)
    throws Exception{
        if (!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return basicOperations.sum(convertToDouble(number1), convertToDouble(number2));
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
        return basicOperations.sub(convertToDouble(number1), convertToDouble(number2));
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
        return basicOperations.mul(convertToDouble(number1), convertToDouble(number2));
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
        return basicOperations.div(convertToDouble(number1), convertToDouble(number2));
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
        return basicOperations.mean(convertToDouble(number1), convertToDouble(number2));
    }

    @RequestMapping(value = "/sqrt/{number1}",
            method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number1") String number1)
            throws Exception{
        if (!isNumeric(number1)){
            throw new UnsupportedOperationException("Please enter with a numeric value!");
        }
        return basicOperations.squareRoot(convertToDouble(number1));
    }

}
