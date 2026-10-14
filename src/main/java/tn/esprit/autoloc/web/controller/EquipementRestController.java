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
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipement")
@RequiredArgsConstructor
@Tag(name = "Gestion Equipement")
public class EquipementRestController {

    private final IEquipementService equipementService;

    @Operation(summary = "Récupérer toutes les equipements")
    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @Operation(summary = "Récupérer une Equipement par son identifiant")
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public ResponseEntity<Equipement> retrieveEquipement(@PathVariable("equipement-id") Long id) {
        Equipement entity = equipementService.retrieveEquipement(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Equipement")
    @PostMapping("/add-equipement")
    public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipementService.addEquipement(entity));
    }

    @Operation(summary = "Modifier une Equipement")
    @PutMapping("/modify-equipement")
    public ResponseEntity<Equipement> modifyEquipement(@RequestBody Equipement entity) {
        return ResponseEntity.ok(equipementService.modifyEquipement(entity));
    }

    @Operation(summary = "Supprimer une Equipement")
    @DeleteMapping("/remove-equipement/{equipement-id}")
    public ResponseEntity<Void> removeEquipement(@PathVariable("equipement-id") Long id) {
        equipementService.removeEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
