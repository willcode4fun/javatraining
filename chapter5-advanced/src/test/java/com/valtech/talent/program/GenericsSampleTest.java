package com.valtech.talent.program;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.Test;

import java.util.List;

public class GenericsSampleTest {

    @Test
    public void should_preprare_paint(){
        List<Shape> shapes =List.of(new Rectangle(2 , 5), new Rectangle(3 ,7), new Disc(3));

        double total = GenericsSample.computeSurface(shapes);

        Assertions.assertThat(total).isCloseTo(59.2, Percentage.withPercentage(1));

    }
}
