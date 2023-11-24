package med.voll.api.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.DadosEndereco;

import java.util.UUID;

public record DadosAtualizacaoMedico(@NotNull
                                     UUID id,
                                     String nome,
                                     String telefone,
                                     DadosEndereco endereco) {
}
