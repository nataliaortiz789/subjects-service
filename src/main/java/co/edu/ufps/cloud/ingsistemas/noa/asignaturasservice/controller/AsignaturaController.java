package co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.controller;

import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.entity.Asignatura;
import co.edu.ufps.cloud.ingsistemas.noa.asignaturasservice.service.AsignaturaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/asignaturas")
@Tag(name = "Asignaturas", description = "Servicio de asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/")
    public ResponseEntity<List<Asignatura>> listarAsignaturas() {
        return new ResponseEntity<>(asignaturaService.listarAsignaturas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignatura(@PathVariable Long id) {
        try {
            Asignatura asignatura= asignaturaService.obtenerAsignaturaPorId(id);
            return new ResponseEntity<Asignatura>(asignatura, HttpStatus.OK);
        }
        catch (Exception excepcion){
            return new ResponseEntity<Asignatura>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura asignatura) {
        try {
            Asignatura asignaturaCreada= asignaturaService.guardarAsignatura(asignatura);
            return new ResponseEntity<Asignatura>(asignaturaCreada, HttpStatus.CREATED);
        }
        catch (Exception excepcion){
            return new ResponseEntity<Asignatura>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizarAsignatura (@RequestBody Asignatura asignatura, @PathVariable Long id) {
        try {
            Asignatura asignaturaExistente = asignaturaService.obtenerAsignaturaPorId(id);
            asignaturaExistente.setNombre(asignatura.getNombre());
            asignaturaExistente.setDescripcion(asignatura.getDescripcion());
            asignaturaService.guardarAsignatura(asignaturaExistente);
            return new ResponseEntity<Asignatura>(HttpStatus.OK);
        }
        catch (Exception excepcion) {
            return new ResponseEntity<Asignatura>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/{id}")
    public void eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
    }

}
