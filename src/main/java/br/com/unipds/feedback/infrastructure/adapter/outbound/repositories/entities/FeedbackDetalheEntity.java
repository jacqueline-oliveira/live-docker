package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback_detalhe")
public class FeedbackDetalheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mongo_id", nullable = false)
    private String mongoId;

    @Column(nullable = false)
    private String matricula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
