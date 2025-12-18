package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.local;

import br.com.unipds.feedback.application.port.output.FeedbackRepositoryPort;
import br.com.unipds.feedback.domain.FeedbackDomain;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Profile("local")
public class FeedbackRepositoryAdapterLocal implements FeedbackRepositoryPort {
    private final List<FeedbackDomain> bancoEmMemoria = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public FeedbackDomain save(FeedbackDomain feedback) {

        // simula ID gerado
        if (feedback.getId() == null) {
            feedback.setId(String.valueOf(sequence.getAndIncrement()));
        }

        bancoEmMemoria.add(feedback);
        return feedback;
    }

    @Override
    public Optional<FeedbackDomain> findById(Long id) {
        return bancoEmMemoria.stream()
                .filter(f -> f.getId().equals(String.valueOf(id)))
                .findFirst();
    }

    @Override
    public List<FeedbackDomain> findAll() {
        return new ArrayList<>(bancoEmMemoria);
    }
}
