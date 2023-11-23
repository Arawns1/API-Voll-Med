package med.voll.api.controller;

import med.voll.api.domain.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void saveMedico(@RequestBody DadosCadastroMedico dados){
        System.out.println(dados);
    }
}
