package com.repliforce.calculator.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.repliforce.calculator.converters.NumberConverters.convertToDouble;
import static com.repliforce.calculator.converters.NumberConverters.isNumeric;

public class BasicOperations {

    public Double sum(Double number1, Double number2) throws Exception{
        return number1 + number2;
    }

    public Double sub(Double number1,Double number2) throws Exception{
        return number1 - number2;
    }

    public Double mul(Double number1,Double number2) throws Exception{
        return number1 * number2;
    }

    public Double div(Double number1,Double number2) throws Exception{
        return number1 / number2;
    }

    public Double mean(Double number1,Double number2) throws Exception{
        return (number1 + number2)/2;
    }

    public Double squareRoot(Double number) throws Exception{
        return Math.sqrt(number);
    }

}
