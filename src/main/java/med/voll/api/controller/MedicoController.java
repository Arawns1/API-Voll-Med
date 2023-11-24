package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.Medico;
import med.voll.api.dto.medico.DadosAtualizacaoMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.DadosDetalhamentoMedico;
import med.voll.api.dto.medico.DadosListagemMedicos;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>>getAllMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        Page<DadosListagemMedicos> page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> getMedicoById(@PathVariable UUID id){
        Medico medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> saveMedico(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        Medico medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}")
                            .buildAndExpand(medico.getId())
                            .toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> updateMedico(@RequestBody @Valid DadosAtualizacaoMedico dados){
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedico(@PathVariable UUID id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

}
