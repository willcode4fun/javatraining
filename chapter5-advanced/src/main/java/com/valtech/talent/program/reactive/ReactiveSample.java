package com.valtech.talent.program.reactive;

import com.valtech.talent.program.ws.ConversionService;
import com.valtech.talent.program.ws.ConversionServiceImpl;
import io.reactivex.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ReactiveSample {

    private static ConversionService conversionService = new ConversionServiceImpl();

    public static void main(String[] args) {

        Random random = new Random();

        Observable<Integer> tick = Observable.interval(1, TimeUnit.SECONDS).take(10).map(Long::intValue);

        Observable<String> integers = Observable.range(0, 100)

                .map(i -> random.nextInt(5000))

                .map(conversionService::convert);

        tick.zipWith(integers, (a,b) -> a+" : "+b )

                .take(10)

                .subscribe(System.out::println);
    }
}
