# API Med Voll - Alura



<h1 align="center">
<img height="150" width="300" src="C:\Users\Gabriel\Desktop\Screenshot_3.jpg" />
</h1>

Projeto de API CRUD simples utilizando Spring Boot e aplicando a metodologia do Git Flow para melhor controle de versionamento

# 🛠 Tecnologias Utilizadas
 - SpringBoot com Maven
 - Lombok
 - JPA Bean Validation

# 📃 Diagrama
```mermaid
classDiagram
  class Medico {
    +UUID id
    +String nome
    +String email
    +String crm
    +String telefone
    +boolean ativo
    +Especialidade especialidade
    +Endereco endereco
    --
    +Medico(DadosCadastroMedico dados)
    +void atualizarInformacoes(DadosAtualizacaoMedico dados)
    +void excluir()
  }

  class Endereco {
    +String logradouro
    +String bairro
    +String cep
    +String cidade
    +String uf
    +String numero
    +String complemento
    --
    +Endereco(DadosEndereco endereco)
    +void atualizarInformacoes(DadosEndereco dados)
  }

  class Especialidade {
    ORTOPEDIA
    CARDIOLOGIA
    GINECOLOGIA
    DERMATOLOGIA
  }

  class DadosCadastroMedico {
    +String nome
    +String email
    +String crm
    +String telefone
    +Especialidade especialidade
    +DadosEndereco endereco
  }

  class DadosAtualizacaoMedico {
    +String nome
    +String telefone
    +DadosEndereco endereco
  }

  class DadosEndereco {
    +String logradouro
    +String bairro
    +String cep
    +String cidade
    +String uf
    +String numero
    +String complemento
  }

  Medico --|> Endereco
  Medico --> Especialidade
  Medico --> DadosCadastroMedico
  Medico --> DadosAtualizacaoMedico
  DadosCadastroMedico --> DadosEndereco
  DadosAtualizacaoMedico --> DadosEndereco

```

## 💻 Como Rodar?

1. Clone o repositório
```bash
git clone https://github.com/Arawns1/Projeto-NekiSkills.git
```
3. Basta iniciar a aplicação normalmente, utilizando a IDE preferida.

Por padrão, a aplicação é iniciada em http://localhost:8080/