package com.valtech.talent.program;

import com.dataaccess.webservicesserver.NumberConversion;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);


        }

        String number = new NumberConversion().getNumberConversionSoap().numberToWords(BigInteger.valueOf(123456l));
    }
}
