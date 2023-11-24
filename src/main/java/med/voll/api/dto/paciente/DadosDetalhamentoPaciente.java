package med.voll.api.dto.paciente;

import med.voll.api.domain.Paciente;

import java.util.UUID;

public record DadosDetalhamentoPaciente(UUID id, String nome, String email, String cpf, String telefone) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
