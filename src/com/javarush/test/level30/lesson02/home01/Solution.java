package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/**
 * Created by stas on 8/30/16.
 */
public class Solution
{
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
    }



    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {

        // create big integer using constructor with radix (radix=numeration format)
        BigInteger bigInt = new BigInteger(number.getDigit(),number.getNumerationSystem().getNumerationSystemIntValue());

        // create string using overloaded BigInteger toString method that accepts radix as argument
        String convDigit =  bigInt.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, convDigit);
    }
}
