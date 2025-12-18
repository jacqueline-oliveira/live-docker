package br.com.unipds.feedback.infrastructure.adapter.inbound.controller.mapper;

import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import br.com.unipds.feedback.domain.FeedbackDomain;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto.FeedbackDetalheResponseDto;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto.FeedbackRequestDto;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto.FeedbackResponseDto;

import java.time.LocalDate;

public class FeedbackControllerMapper {

    private FeedbackControllerMapper() {}

    public static FeedbackDomain toDomain(FeedbackRequestDto dto) {
        return new FeedbackDomain(
                null,
                dto.matricula(),
                LocalDate.now(),
                dto.modulo(),
                dto.observacao()
        );
    }


    public static FeedbackResponseDto toResponseDto(FeedbackDomain domain) {
        return new FeedbackResponseDto(
                domain.getId(),
                domain.getMatricula(),
                domain.getModulo(),
                domain.getObservacao(),
                domain.getData()
        );
    }

    public static FeedbackDetalheResponseDto toDetalheResponseDto(
            FeedbackDetalheDomain domain) {

        return new FeedbackDetalheResponseDto(
                domain.getMatricula(),
                domain.getMongoId()
        );
    }
}
