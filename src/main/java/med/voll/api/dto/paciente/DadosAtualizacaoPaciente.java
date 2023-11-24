package med.voll.api.dto.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.DadosEndereco;

import java.util.UUID;

public record DadosAtualizacaoPaciente(@NotNull
                                     UUID id,
                                       String nome,
                                       String telefone,
                                       DadosEndereco endereco) {
}
