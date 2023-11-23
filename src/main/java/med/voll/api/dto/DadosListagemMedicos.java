package med.voll.api.dto;

import med.voll.api.domain.Especialidade;
import med.voll.api.domain.Medico;

import java.util.UUID;

public record DadosListagemMedicos(UUID id,
                                   String nome,
                                   String email,
                                   String crm,
                                   Especialidade especialidade) {

    public DadosListagemMedicos(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
