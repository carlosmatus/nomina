package com.cm.nom;


import com.cm.nom.service.NominaService;
import com.cm.nom.service.NominaServiceImpl;
import com.google.inject.Inject;
import io.reactivex.Observable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NominaServiceApplication implements CommandLineRunner {
	private NominaService nominaService;
	@Inject
	public NominaServiceApplication(NominaServiceImpl nominaService) {
		this.nominaService = nominaService;
	}
	public static void main(String[] args) {

		SpringApplication.run(NominaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		AtomicInteger counter = new AtomicInteger();
//		Callable<Integer> callable = () -> counter.incrementAndGet();
//
//		Observable<Integer> source = Observable.fromCallable(callable);
//
//		for (int i = 1; i < 5; i++) {
//			source.test()
//					.awaitDone(5, TimeUnit.SECONDS)
//					.assertResult(i);
//			System.out.println("i , "+i+" Counter "+ counter.get());
//		}
		System.out.println("Desde el metodo Run ");

		nominaService.getSalarioMensual().subscribe(x->System.out.println("El valor de la llamada es :"+x));
	}
}
