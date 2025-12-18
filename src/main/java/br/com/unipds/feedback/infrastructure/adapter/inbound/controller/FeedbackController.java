package br.com.unipds.feedback.infrastructure.adapter.inbound.controller;

import br.com.unipds.feedback.application.port.input.FeedbackUseCase;
import br.com.unipds.feedback.domain.FeedbackDetalheDomain;
import br.com.unipds.feedback.domain.FeedbackDomain;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto.FeedbackDetalheResponseDto;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto.FeedbackRequestDto;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.dto.FeedbackResponseDto;
import br.com.unipds.feedback.infrastructure.adapter.inbound.controller.mapper.FeedbackControllerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackUseCase feedbackUseCase;

    public FeedbackController(FeedbackUseCase feedbackUseCase) {
        this.feedbackUseCase = feedbackUseCase;
    }

    @PostMapping
    public ResponseEntity<FeedbackResponseDto> salvar(
            @RequestBody FeedbackRequestDto request) {

        FeedbackDomain domain = FeedbackControllerMapper.toDomain(request);

        FeedbackDomain salvo =
                feedbackUseCase.salvarFeedback(domain);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(FeedbackControllerMapper.toResponseDto(salvo));
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponseDto>> listarTodos() {
        return ResponseEntity.ok(
                feedbackUseCase.buscarTodos()
                        .stream()
                        .map(FeedbackControllerMapper::toResponseDto)
                        .toList()
        );
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<List<FeedbackDetalheResponseDto>> buscarPorMatricula(
            @PathVariable String matricula) {

        List<FeedbackDetalheDomain> detalhes =
                feedbackUseCase.buscarPorMatricula(matricula);

        return ResponseEntity.ok(
                detalhes.stream()
                        .map(FeedbackControllerMapper::toDetalheResponseDto)
                        .toList()
        );
    }


}
