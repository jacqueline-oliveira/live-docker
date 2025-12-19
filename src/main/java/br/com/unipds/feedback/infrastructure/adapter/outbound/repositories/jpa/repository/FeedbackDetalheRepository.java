package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.repository;

import br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.jpa.entities.FeedbackDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackDetalheRepository extends JpaRepository<FeedbackDetalheEntity, Long> {

    List<FeedbackDetalheEntity> findByMatricula(String matricula);
}
