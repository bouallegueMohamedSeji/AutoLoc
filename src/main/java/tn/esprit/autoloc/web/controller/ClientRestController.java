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
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Tag(name = "Gestion Client")
public class ClientRestController {

    private final IClientService clientService;

    @Operation(summary = "Récupérer toutes les clients")
    @GetMapping("/retrieve-all-clients")
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @Operation(summary = "Récupérer une Client par son identifiant")
    @GetMapping("/retrieve-client/{client-id}")
    public ResponseEntity<Client> retrieveClient(@PathVariable("client-id") Long id) {
        Client entity = clientService.retrieveClient(id);
        return entity == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity);
    }

    @Operation(summary = "Ajouter une Client")
    @PostMapping("/add-client")
    public ResponseEntity<Client> addClient(@RequestBody Client entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(entity));
    }

    @Operation(summary = "Modifier une Client")
    @PutMapping("/modify-client")
    public ResponseEntity<Client> modifyClient(@RequestBody Client entity) {
        return ResponseEntity.ok(clientService.modifyClient(entity));
    }

    @Operation(summary = "Supprimer une Client")
    @DeleteMapping("/remove-client/{client-id}")
    public ResponseEntity<Void> removeClient(@PathVariable("client-id") Long id) {
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
