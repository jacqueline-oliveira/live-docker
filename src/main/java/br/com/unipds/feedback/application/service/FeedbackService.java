package br.com.unipds.feedback.application.service;

import br.com.unipds.feedback.application.port.input.FeedbackUseCase;
import br.com.unipds.feedback.application.port.output.FeedbackDetalheRepositoryPort;
import br.com.unipds.feedback.application.port.output.FeedbackRepositoryPort;
import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import br.com.unipds.feedback.domain.FeedbackDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements FeedbackUseCase {

    private final FeedbackRepositoryPort repository;
    private final FeedbackDetalheRepositoryPort detalheRepository;

    public FeedbackService(FeedbackRepositoryPort repository, FeedbackDetalheRepositoryPort detalheRepository) {
        this.repository = repository;
        this.detalheRepository = detalheRepository;
    }


    @Override
    public FeedbackDomain salvarFeedback(FeedbackDomain domain) {
        FeedbackDomain feedbackSalvo = repository.save(domain);
        FeedbackDetalheDomain detalhe = new FeedbackDetalheDomain(
                null,
                feedbackSalvo.getId(),
                feedbackSalvo.getMatricula()
        );
        detalheRepository.save(detalhe);
        return feedbackSalvo;
    }

    @Override
    public List<FeedbackDomain> buscarTodos() {
        return repository.findAll();
    }


    @Override
    public List<FeedbackDetalheDomain> buscarPorMatricula(String matricula) {
        return detalheRepository.findByMatricula(matricula);
    }
}
