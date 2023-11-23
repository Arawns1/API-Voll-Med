package med.voll.api.repository;

import med.voll.api.domain.Medico;
import med.voll.api.domain.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
  Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
