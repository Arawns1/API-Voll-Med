package med.voll.api.dto;

import med.voll.api.domain.Paciente;

public record DadosListagemPacientes(String nome, String email, String cpf) {

    public DadosListagemPacientes(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
