package com.cm.nom.config;



import com.cm.nom.guice.NominaGuiceModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.guice.annotation.EnableGuiceModules;

@Configuration
@EnableGuiceModules
public class GuiceConfig {

    @Bean
    public NominaGuiceModule myModule() {
        return new NominaGuiceModule();
    }
}
