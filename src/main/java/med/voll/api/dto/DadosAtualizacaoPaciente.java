package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizacaoPaciente(@NotNull
                                     UUID id,
                                       String nome,
                                       String telefone,
                                       DadosEndereco endereco) {
}
