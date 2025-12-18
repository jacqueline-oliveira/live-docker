package br.com.unipds.feedback.application.port.output;

import br.com.unipds.feedback.domain.FeedbackDetalheDomain;

import java.util.List;
import java.util.Optional;

public interface FeedbackDetalheRepositoryPort {
    FeedbackDetalheDomain save(FeedbackDetalheDomain feedback);
    Optional<FeedbackDetalheDomain> findById(Long id);
    List<FeedbackDetalheDomain> findByMatricula(String Matricula);
}
