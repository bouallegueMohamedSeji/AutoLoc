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
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agence")
@RequiredArgsConstructor
@Tag(name = "Gestion Agence")
public class AgenceRestController {

    private final IAgenceService agenceService;

    @Operation(summary = "Récupérer toutes les agences")
    @GetMapping("/retrieve-all-agences")
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @Operation(summary = "Récupérer une Agence par son identifiant")
    @GetMapping("/retrieve-agence/{agence-id}")
    public ResponseEntity<Agence> retrieveAgence(@PathVariable("agence-id") Long id) {
        Agence entity = agenceService.retrieveAgence(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Agence")
    @PostMapping("/add-agence")
    public ResponseEntity<Agence> addAgence(@RequestBody Agence entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.addAgence(entity));
    }

    @Operation(summary = "Modifier une Agence")
    @PutMapping("/modify-agence")
    public ResponseEntity<Agence> modifyAgence(@RequestBody Agence entity) {
        return ResponseEntity.ok(agenceService.modifyAgence(entity));
    }

    @Operation(summary = "Supprimer une Agence")
    @DeleteMapping("/remove-agence/{agence-id}")
    public ResponseEntity<Void> removeAgence(@PathVariable("agence-id") Long id) {
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}
