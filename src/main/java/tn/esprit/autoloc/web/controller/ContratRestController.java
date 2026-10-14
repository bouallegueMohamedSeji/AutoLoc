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
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
@RequiredArgsConstructor
@Tag(name = "Gestion Contrat")
public class ContratRestController {

    private final IContratService contratService;

    @Operation(summary = "Récupérer toutes les contrats")
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @Operation(summary = "Récupérer une Contrat par son identifiant")
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public ResponseEntity<Contrat> retrieveContrat(@PathVariable("contrat-id") Long id) {
        Contrat entity = contratService.retrieveContrat(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Contrat")
    @PostMapping("/add-contrat")
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.addContrat(entity));
    }

    @Operation(summary = "Modifier une Contrat")
    @PutMapping("/modify-contrat")
    public ResponseEntity<Contrat> modifyContrat(@RequestBody Contrat entity) {
        return ResponseEntity.ok(contratService.modifyContrat(entity));
    }

    @Operation(summary = "Supprimer une Contrat")
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public ResponseEntity<Void> removeContrat(@PathVariable("contrat-id") Long id) {
        contratService.removeContrat(id);
        return ResponseEntity.noContent().build();
    }
}
