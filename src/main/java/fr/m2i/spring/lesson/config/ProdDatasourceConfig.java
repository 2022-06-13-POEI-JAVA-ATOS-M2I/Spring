package fr.m2i.spring.lesson.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDatasourceConfig implements DatasourceConfig {

    @Override
    public void setup() {
        System.out.println("Setting up datasource for PRODUCTION environment.");

    }

}
