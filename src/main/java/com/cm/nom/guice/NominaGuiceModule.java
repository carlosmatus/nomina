package com.cm.nom.guice;


import com.cm.nom.service.NominaService;
import com.cm.nom.service.NominaServiceImpl;
import com.google.inject.AbstractModule;

public class NominaGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        System.out.println("Desde el configu de abstract Module");
        bind(NominaService.class).to(NominaServiceImpl.class);

    }
}
