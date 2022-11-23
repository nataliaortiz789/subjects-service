package co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.service;

import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.entity.Asignatura;

import java.util.List;

public interface AsignaturaService {

    public List<Asignatura> listarAsignaturas();

    public Asignatura obtenerAsignaturaPorId(Long id);

    public Asignatura guardarAsignatura(Asignatura asignatura);

    public Asignatura actualizarAsignatura(Asignatura asignatura);

    public void eliminarAsignatura(Long id);

}
