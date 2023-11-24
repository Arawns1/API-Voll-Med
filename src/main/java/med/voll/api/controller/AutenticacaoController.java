package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.Usuario;
import med.voll.api.dto.security.DadosAutenticacao;
import med.voll.api.dto.security.DadosTokenJWT;
import med.voll.api.repository.UsuarioRepository;
import med.voll.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity efetuarCadastro(@RequestBody @Valid DadosAutenticacao dados){

        if(repository.findByLogin(dados.login()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Usuário já cadastrado");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario savedUser = repository.save(new Usuario(dados.login(), encryptedPassword));
        var authenticationToken = new UsernamePasswordAuthenticationToken(savedUser.getLogin(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }


    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
