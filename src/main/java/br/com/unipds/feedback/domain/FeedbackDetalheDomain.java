package br.com.unipds.feedback.domain;

public class FeedbackDetalheDomain {
    private Long id;
    private String mongoId;
    private String matricula;

    public FeedbackDetalheDomain(Long id, String mongoId, String matricula) {
        this.id = id;
        this.mongoId = mongoId;
        this.matricula = matricula;
    }

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
