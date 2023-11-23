package med.voll.api.domain;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.DadosAtualizacaoPaciente;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.dto.DadosCadastroPaciente;

import java.util.UUID;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private boolean ativo;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    //Embeddable Atributes
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
