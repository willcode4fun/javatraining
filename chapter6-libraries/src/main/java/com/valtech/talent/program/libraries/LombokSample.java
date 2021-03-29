package com.valtech.talent.program.libraries;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokSample {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    @Builder
    public static  class SamplePojo {
        private int num;
        private String name;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static  class SampleImmutable {
        private int num;
        private String name;
    }


    public static void main(String[] args) {

      log.info("OK");

        ///SamplePojo pojo1 = new SamplePojo();




      SamplePojo pojo = SamplePojo.builder().name("test").build();

      pojo.getName();

      SampleImmutable imm = SampleImmutable.builder().num(45).build();
    }
}
