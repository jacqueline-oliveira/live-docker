package br.com.unipds.feedback.application.port.output;

import br.com.unipds.feedback.domain.FeedbackDomain;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepositoryPort {
    FeedbackDomain save(FeedbackDomain feedback);
    Optional<FeedbackDomain> findById(Long id);
    List<FeedbackDomain> findAll();
}
