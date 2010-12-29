package com.tecacet.jflat.util.conversion;

import java.math.BigDecimal;

import org.junit.Test;

import com.tecacet.jflat.util.conversion.BigDecimalToStringConverter;

public class BigDecimalStringConverterTest {

    @Test
    public void testConvertToString() {
       BigDecimalToStringConverter converter = new BigDecimalToStringConverter();
       converter.convertToString(new BigDecimal(0.00000001)); //NO Exception
    }

}
