package com.valtech.talent.program.ws;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceImplTest {

    ConversionService service = new ConversionServiceImpl();

    @Test
    public void should_call_conversion_service() {

        assertThat(service.convert(0)).isEqualTo("zero");

        assertThat(service.convert(1000)).isEqualTo("one thousand");
    }

}