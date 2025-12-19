package br.com.unipds.feedback.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages =  "br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa")
public class JpaConfig {
}
