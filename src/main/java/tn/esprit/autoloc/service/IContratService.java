package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat retrieveContrat(Long id);
    Contrat addContrat(Contrat entity);
    Contrat modifyContrat(Contrat entity);
    void removeContrat(Long id);
}
