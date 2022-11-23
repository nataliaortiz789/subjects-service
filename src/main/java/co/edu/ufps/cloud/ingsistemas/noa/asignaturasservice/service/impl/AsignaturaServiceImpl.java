package co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.service.impl;

import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.entity.Asignatura;
import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.repository.AsignaturaRepository;
import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    @Override
    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura actualizarAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void eliminarAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }

}
