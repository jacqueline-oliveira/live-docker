package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.repository;

import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.entities.FeedbackDocumentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackDocumentRepository extends MongoRepository<FeedbackDocumentEntity, String>  {
}
