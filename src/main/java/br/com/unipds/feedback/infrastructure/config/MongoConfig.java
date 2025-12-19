package br.com.unipds.feedback.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mongo"
)
public class MongoConfig {
}
