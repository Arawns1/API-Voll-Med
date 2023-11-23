package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Getter;
import med.voll.api.domain.Medico;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.dto.DadosListagemMedicos;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public List<DadosListagemMedicos> getAllMedicos(){
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }
    @PostMapping
    @Transactional
    public void saveMedico(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
