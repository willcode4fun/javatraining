package com.valtech.talent.program.libraries;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;

import static com.google.common.base.Charsets.UTF_8;

public class CommonsSample {

    public static void main(String[] args) throws IOException {

        boolean blank = StringUtils.isBlank(" ");

        boolean alphanumeric = StringUtils.isAlphanumeric("abc123");

        long[] array = {123456l, 456789l, 456789l};
        ArrayUtils.shuffle(array);

        long min = NumberUtils.min(array);

        IOUtils.readLines(CommonsSample.class.getResourceAsStream("test.txt"), UTF_8);

    }
}
