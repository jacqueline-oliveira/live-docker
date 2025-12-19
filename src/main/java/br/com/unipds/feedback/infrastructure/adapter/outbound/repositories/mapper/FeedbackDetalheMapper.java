package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mapper;

import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.entities.FeedbackDetalheEntity;

public class FeedbackDetalheMapper {
    private FeedbackDetalheMapper() {

    }

    public static FeedbackDetalheDomain toDomain(FeedbackDetalheEntity entity) {
        if (entity == null) {
            return null;
        }

        return new FeedbackDetalheDomain(
                entity.getId(),
                entity.getMongoId(),
                entity.getMatricula()
        );
    }

    public static FeedbackDetalheEntity toEntity(FeedbackDetalheDomain domain) {
        if (domain == null) {
            return null;
        }

        FeedbackDetalheEntity entity = new FeedbackDetalheEntity();
        entity.setId(domain.getId());
        entity.setMongoId(domain.getMongoId());
        entity.setMatricula(domain.getMatricula());

        return entity;
    }
}
