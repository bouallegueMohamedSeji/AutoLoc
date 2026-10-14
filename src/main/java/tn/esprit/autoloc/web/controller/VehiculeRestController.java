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
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
@RequiredArgsConstructor
@Tag(name = "Gestion Vehicule")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Récupérer toutes les vehicules")
    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @Operation(summary = "Récupérer une Vehicule par son identifiant")
    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public ResponseEntity<Vehicule> retrieveVehicule(@PathVariable("vehicule-id") Long id) {
        Vehicule entity = vehiculeService.retrieveVehicule(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Vehicule")
    @PostMapping("/add-vehicule")
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.addVehicule(entity));
    }

    @Operation(summary = "Modifier une Vehicule")
    @PutMapping("/modify-vehicule")
    public ResponseEntity<Vehicule> modifyVehicule(@RequestBody Vehicule entity) {
        return ResponseEntity.ok(vehiculeService.modifyVehicule(entity));
    }

    @Operation(summary = "Supprimer une Vehicule")
    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public ResponseEntity<Void> removeVehicule(@PathVariable("vehicule-id") Long id) {
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
