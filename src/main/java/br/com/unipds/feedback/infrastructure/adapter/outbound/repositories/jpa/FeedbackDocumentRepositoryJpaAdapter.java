package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa;

import br.com.unipds.feedback.application.port.output.FeedbackRepositoryPort;
import br.com.unipds.feedback.domain.FeedbackDomain;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.entities.FeedbackDocumentEntity;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.repository.FeedbackDocumentRepository;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mapper.FeedbackDocumentMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Profile("prod")
public class FeedbackDocumentRepositoryJpaAdapter implements FeedbackRepositoryPort {

    public FeedbackDocumentRepositoryJpaAdapter(FeedbackDocumentRepository repository) {
        this.repository = repository;
    }

    private final FeedbackDocumentRepository repository;

    @Override
    public FeedbackDomain save(FeedbackDomain feedback) {
        FeedbackDocumentEntity entity = FeedbackDocumentMapper.toEntity(feedback);
        return FeedbackDocumentMapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<FeedbackDomain> findById(Long id) {
        return repository
                .findById(id.toString())
                .map(FeedbackDocumentMapper::toDomain);
    }

    @Override
    public List<FeedbackDomain> findAll() {
        return repository
                .findAll()
                .stream()
                .map(FeedbackDocumentMapper::toDomain)
                .toList();
    }
}
