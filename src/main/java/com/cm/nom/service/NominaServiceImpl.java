package com.cm.nom.service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class NominaServiceImpl implements NominaService {

    public Mono<Double> getSalarioMensual() {
        WebClient webClient = WebClient.create();
               // .baseUrl("https://api.github.com")
                //.defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.github.v3+json")
                //.defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                //.build();
        System.out.println("Intentando conectarse al server *****");
        Mono.zip(webClient.get().uri("http://127.0.0.1:8763/employees/1/200").retrieve().bodyToMono(Double.class),
                webClient.get().uri("http://127.0.0.1:8763/employees/1/400").retrieve().bodyToMono(Double.class))
                .subscribe(result -> System.out.println("El resultado es :"+(result.getT2()-result.getT1()*.25)));
        return  webClient.get().uri("http://127.0.0.1:8763/employees/1/20").retrieve().bodyToMono(Double.class);
    }
}
