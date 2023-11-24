package med.voll.api.dto;

import med.voll.api.domain.Endereco;
import med.voll.api.domain.Especialidade;
import med.voll.api.domain.Medico;

import java.util.UUID;

public record DadosDetalhamentoMedico(UUID id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
