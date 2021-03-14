package com.valtech.talent.program.ws;

import com.dataaccess.webservicesserver.NumberConversion;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class ConversionServiceImpl implements ConversionService {

    @Override
    public String convert(int num) {
        return new NumberConversion().getNumberConversionSoap().numberToWords(BigInteger.valueOf(num));
    }
}
