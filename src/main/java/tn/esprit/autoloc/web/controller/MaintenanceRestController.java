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
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
@RequiredArgsConstructor
@Tag(name = "Gestion Maintenance")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Récupérer toutes les maintenances")
    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @Operation(summary = "Récupérer une Maintenance par son identifiant")
    @GetMapping("/retrieve-maintenance/{maintenance-id}")
    public ResponseEntity<Maintenance> retrieveMaintenance(@PathVariable("maintenance-id") Long id) {
        Maintenance entity = maintenanceService.retrieveMaintenance(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Maintenance")
    @PostMapping("/add-maintenance")
    public ResponseEntity<Maintenance> addMaintenance(@RequestBody Maintenance entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceService.addMaintenance(entity));
    }

    @Operation(summary = "Modifier une Maintenance")
    @PutMapping("/modify-maintenance")
    public ResponseEntity<Maintenance> modifyMaintenance(@RequestBody Maintenance entity) {
        return ResponseEntity.ok(maintenanceService.modifyMaintenance(entity));
    }

    @Operation(summary = "Supprimer une Maintenance")
    @DeleteMapping("/remove-maintenance/{maintenance-id}")
    public ResponseEntity<Void> removeMaintenance(@PathVariable("maintenance-id") Long id) {
        maintenanceService.removeMaintenance(id);
        return ResponseEntity.noContent().build();
    }
}
