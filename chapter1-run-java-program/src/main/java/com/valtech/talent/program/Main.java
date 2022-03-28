package com.valtech.talent.program;

import com.dataaccess.webservicesserver.NumberConversion;

import java.math.BigInteger;

/*
*
* After mvn clean install, run with :
* java -jar target/chapter1-run-java-program-1.0-SNAPSHOT.jar toto titi
*
* */

public class Main {

    public static final long NUMBER = 123456l;

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        String numberAsWords = new NumberConversion().getNumberConversionSoap().numberToWords(BigInteger.valueOf(NUMBER));
        System.out.println(NUMBER + "=" + numberAsWords);
    }
}
