package com.cm.nom.service;

import reactor.core.publisher.Mono;

public interface NominaService {
    public Mono<Double> getSalarioMensual();
}
