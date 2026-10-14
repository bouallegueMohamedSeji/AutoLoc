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
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
@Tag(name = "Gestion Reservation")
public class ReservationRestController {

    private final IReservationService reservationService;

    @Operation(summary = "Récupérer toutes les reservations")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @Operation(summary = "Récupérer une Reservation par son identifiant")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public ResponseEntity<Reservation> retrieveReservation(@PathVariable("reservation-id") Long id) {
        Reservation entity = reservationService.retrieveReservation(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Reservation")
    @PostMapping("/add-reservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addReservation(entity));
    }

    @Operation(summary = "Modifier une Reservation")
    @PutMapping("/modify-reservation")
    public ResponseEntity<Reservation> modifyReservation(@RequestBody Reservation entity) {
        return ResponseEntity.ok(reservationService.modifyReservation(entity));
    }

    @Operation(summary = "Supprimer une Reservation")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public ResponseEntity<Void> removeReservation(@PathVariable("reservation-id") Long id) {
        reservationService.removeReservation(id);
        return ResponseEntity.noContent().build();
    }
}
