package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.repository;

import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.entities.FeedbackDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackDetalheRepository extends JpaRepository<FeedbackDetalheEntity, Long> {

    List<FeedbackDetalheEntity> findByMatricula(String matricula);
}
