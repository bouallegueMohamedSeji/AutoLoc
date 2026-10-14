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
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
@RequiredArgsConstructor
@Tag(name = "Gestion Paiement")
public class PaiementRestController {

    private final IPaiementService paiementService;

    @Operation(summary = "Récupérer toutes les paiements")
    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @Operation(summary = "Récupérer une Paiement par son identifiant")
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public ResponseEntity<Paiement> retrievePaiement(@PathVariable("paiement-id") Long id) {
        Paiement entity = paiementService.retrievePaiement(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Paiement")
    @PostMapping("/add-paiement")
    public ResponseEntity<Paiement> addPaiement(@RequestBody Paiement entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.addPaiement(entity));
    }

    @Operation(summary = "Modifier une Paiement")
    @PutMapping("/modify-paiement")
    public ResponseEntity<Paiement> modifyPaiement(@RequestBody Paiement entity) {
        return ResponseEntity.ok(paiementService.modifyPaiement(entity));
    }

    @Operation(summary = "Supprimer une Paiement")
    @DeleteMapping("/remove-paiement/{paiement-id}")
    public ResponseEntity<Void> removePaiement(@PathVariable("paiement-id") Long id) {
        paiementService.removePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
