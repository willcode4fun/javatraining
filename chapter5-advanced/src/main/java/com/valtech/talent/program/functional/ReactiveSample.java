package com.valtech.talent.program.functional;

import io.reactivex.Completable;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ReactiveSample {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> observable = Observable.just("Toto");

        Observable<Integer> range = Observable.range(0, 100);

        Observable<Long> tick = Observable.interval(1, TimeUnit.SECONDS)
                .take(10);

        Observable.fromCallable(ReactiveSample::callMethod);

        // in completable there is no data but an event is sent to the observer
        Completable.fromAction(ReactiveSample::actionMethod);

        Observable<String> observable2 = Observable.fromArray("Mario", "Luigi", "Bowser", "Donkey Kong");


        observable.subscribe(System.out::println);


        Observable.interval(1, TimeUnit.SECONDS)

                .take(10)

                .subscribe((a) -> System.out.println("TICK "+a));


        observable2.subscribe(
                System.out::println, // on Next
                Throwable::printStackTrace, // on Error
                () -> System.out.println("Finished") // on Completed
        );


        Observable.interval(100, TimeUnit.MILLISECONDS)
                .take(10)
                .filter(i -> i%2 ==0)
                .map(Object::toString)
                .subscribe(System.out::println);


        Observable<String> stringObservable1 = Observable.fromCallable(() -> "toto");

        Observable<String> stringObservable2 = Observable.fromCallable(() -> "bob");


        Observable.zip(
                stringObservable1,
                stringObservable2,
                (a,b)-> a+b)
            .subscribe(a ->  System.out.println("Bob and Toto are here"));

        Thread.sleep(5000);
    }

    private static void actionMethod(){
        System.out.println("actionMethod");
    }

    private static String callMethod(){
        System.out.println("callMethod");
        return "SOMEVALUE";
    }
}
