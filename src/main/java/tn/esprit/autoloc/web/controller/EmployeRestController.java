package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employe")
@RequiredArgsConstructor
@Tag(name = "Gestion Employe")
public class EmployeRestController {

    private final IEmployeService employeService;

    @Operation(summary = "Récupérer toutes les employes")
    @GetMapping("/retrieve-all-employes")
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @Operation(summary = "Récupérer une Employe par son identifiant")
    @GetMapping("/retrieve-employe/{employe-id}")
    public ResponseEntity<Employe> retrieveEmploye(@PathVariable("employe-id") Long id) {
        Employe entity = employeService.retrieveEmploye(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Employe")
    @PostMapping("/add-employe")
    public ResponseEntity<Employe> addEmploye(@RequestBody Employe entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.addEmploye(entity));
    }

    @Operation(summary = "Modifier une Employe")
    @PutMapping("/modify-employe")
    public ResponseEntity<Employe> modifyEmploye(@RequestBody Employe entity) {
        return ResponseEntity.ok(employeService.modifyEmploye(entity));
    }

    @Operation(summary = "Supprimer une Employe")
    @DeleteMapping("/remove-employe/{employe-id}")
    public ResponseEntity<Void> removeEmploye(@PathVariable("employe-id") Long id) {
        employeService.removeEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
