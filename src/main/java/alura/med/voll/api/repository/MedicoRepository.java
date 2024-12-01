package alura.med.voll.api.repository;

import alura.med.voll.api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);
}
