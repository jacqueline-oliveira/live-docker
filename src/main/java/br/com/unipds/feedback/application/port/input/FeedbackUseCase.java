package br.com.unipds.feedback.application.port.input;

import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import br.com.unipds.feedback.domain.FeedbackDomain;

import java.util.List;

public interface FeedbackUseCase {
    FeedbackDomain salvarFeedback(FeedbackDomain domain);
    List<FeedbackDomain> buscarTodos();
    List<FeedbackDetalheDomain> buscarPorMatricula(String matricula);

}
