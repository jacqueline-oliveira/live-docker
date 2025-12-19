package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mongo.repository;

import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mongo.entities.FeedbackDocumentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDocumentRepository extends MongoRepository<FeedbackDocumentEntity, String>  {
}
