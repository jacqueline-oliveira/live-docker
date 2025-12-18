package br.com.unipds.feedback.infrastructure.adapter.outbound.repositories.entities;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "feedbacks")
public class FeedbackDocumentEntity {
    @Id
    private String id;

    private String matricula;
    private LocalDate data;
    private String modulo;
    private String observacao;

    public FeedbackDocumentEntity() {}

    public FeedbackDocumentEntity(String id, String matricula, LocalDate data, String modulo, String observacao) {
        this.id = id;
        this.matricula = matricula;
        this.data = data;
        this.modulo = modulo;
        this.observacao = observacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
