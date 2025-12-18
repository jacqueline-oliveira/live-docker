package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.local;

import br.com.unipds.feedback.application.port.output.FeedbackDetalheRepositoryPort;
import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Profile("local")
public class FeedbackDetalheRepositoryAdapterLocal implements FeedbackDetalheRepositoryPort {

    private final List<FeedbackDetalheDomain> bancoEmMemoria = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public FeedbackDetalheDomain save(FeedbackDetalheDomain feedback) {

        // simula ID auto-increment
        if (feedback.getId() == null) {
            feedback.setId(sequence.getAndIncrement());
        }

        bancoEmMemoria.add(feedback);
        return feedback;
    }

    @Override
    public Optional<FeedbackDetalheDomain> findById(Long id) {
        return bancoEmMemoria.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<FeedbackDetalheDomain> findByMatricula(String matricula) {
        return bancoEmMemoria.stream()
                .filter(f -> f.getMatricula().equalsIgnoreCase(matricula))
                .toList();
    }
}
