package br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto;

public record FeedbackRequestDto(
        String matricula,
        String modulo,
        String observacao
) {
}
