package com.cm.nom.NominaService;

import hu.akarnokd.rxjava2.async.AsyncObservable;
import io.reactivex.Observable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NominaServiceApplicationTests {
	AtomicInteger counter = new AtomicInteger();
	Callable<Integer> callable = () -> counter.incrementAndGet();
	@Test
	public void contextLoads() {
	}

	@Test
			public void miTest() {


		ExecutorService executor = Executors.newSingleThreadExecutor();
		Observable<Integer> source = AsyncObservable.startFuture(() -> executor.submit(callable));

		for (int i = 1; i < 5; i++) {
			source.test()
					.awaitDone(5, TimeUnit.SECONDS)
					.assertResult(i);
			assertEquals(i, counter.get());
		}
		executor.shutdown();
	}

	public void secondTest(){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(callable);
		Observable<Integer> source = Observable.fromFuture(future);

		for (int i = 1; i < 5; i++) {
			source.test()
					.awaitDone(5, TimeUnit.SECONDS)
					.assertResult(1);
			assertEquals(1, counter.get());
		}
		executor.shutdown();
	}
}
