package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizacaoMedico(@NotNull
                                     UUID id,
                                     String nome,
                                     String telefone,
                                     DadosEndereco endereco) {
}
