package com.valtech.talent.program.libraries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokSample {

    @Data
    @Builder
    public static  class SamplePojo {
        public int num;
        public String name;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static  class SampleImmutable {
        public int num;
        public String name;
    }


    public static void main(String[] args) {
      log.info("OK");

      SamplePojo pojo = SamplePojo.builder().name("test").build();

      pojo.getName();

      SampleImmutable imm = SampleImmutable.builder().num(45).build();
    }
}
