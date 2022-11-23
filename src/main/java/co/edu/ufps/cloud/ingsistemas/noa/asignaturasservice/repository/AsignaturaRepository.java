package co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.repository;

import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

}
