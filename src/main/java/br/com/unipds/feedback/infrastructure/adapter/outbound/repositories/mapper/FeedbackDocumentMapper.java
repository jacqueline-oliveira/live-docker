package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mapper;

import br.com.unipds.feedback.domain.FeedbackDomain;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mongo.entities.FeedbackDocumentEntity;

public class FeedbackDocumentMapper {

    private FeedbackDocumentMapper() {
        // evita instanciação
    }

    public static FeedbackDomain toDomain(FeedbackDocumentEntity entity) {
        if (entity == null) {
            return null;
        }

        return new FeedbackDomain(
                entity.getId(),
                entity.getMatricula(),
                entity.getData(),
                entity.getModulo(),
                entity.getObservacao()
        );
    }

    public static FeedbackDocumentEntity toEntity(FeedbackDomain domain) {
        if (domain == null) {
            return null;
        }

        return new FeedbackDocumentEntity(
                domain.getId(),
                domain.getMatricula(),
                domain.getData(),
                domain.getModulo(),
                domain.getObservacao()
        );
    }
}
