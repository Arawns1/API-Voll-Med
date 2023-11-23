package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.domain.Medico;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void saveMedico(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
