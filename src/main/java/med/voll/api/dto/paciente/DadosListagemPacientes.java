package med.voll.api.dto.paciente;

import med.voll.api.domain.Paciente;

import java.util.UUID;

public record DadosListagemPacientes(UUID id, String nome, String email, String cpf) {

    public DadosListagemPacientes(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
