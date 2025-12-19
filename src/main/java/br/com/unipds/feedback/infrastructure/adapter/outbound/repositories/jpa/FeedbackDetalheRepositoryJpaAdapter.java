package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa;

import br.com.unipds.feedback.application.port.output.FeedbackDetalheRepositoryPort;
import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.entities.FeedbackDetalheEntity;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.repository.FeedbackDetalheRepository;
import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.mapper.FeedbackDetalheMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FeedbackDetalheRepositoryJpaAdapter implements FeedbackDetalheRepositoryPort {

    private final FeedbackDetalheRepository repository;

    public FeedbackDetalheRepositoryJpaAdapter(FeedbackDetalheRepository repository) {
        this.repository = repository;
    }

    @Override
    public FeedbackDetalheDomain save(FeedbackDetalheDomain feedback) {
        FeedbackDetalheEntity entity = FeedbackDetalheMapper.toEntity(feedback);
        return FeedbackDetalheMapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<FeedbackDetalheDomain> findById(Long id) {
        return repository
                .findById(id)
                .map(FeedbackDetalheMapper::toDomain);
    }

    @Override
    public List<FeedbackDetalheDomain> findByMatricula(String matricula) {
        return repository
                .findByMatricula(matricula)
                .stream()
                .map(FeedbackDetalheMapper::toDomain)
                .toList();
    }
}
