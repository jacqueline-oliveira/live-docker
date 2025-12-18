package br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto;

import java.time.LocalDate;

public record FeedbackResponseDto(
        String id,
        String matricula,
        String modulo,
        String observacao,
        LocalDate data
) {
}
