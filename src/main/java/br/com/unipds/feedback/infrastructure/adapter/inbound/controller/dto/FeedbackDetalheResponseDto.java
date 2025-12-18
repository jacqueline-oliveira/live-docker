package br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto;

public record FeedbackDetalheResponseDto(
        String matricula,
        String mongoId
) {
}
