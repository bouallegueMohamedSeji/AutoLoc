package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat retrieveContrat(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat addContrat(Contrat entity) {
        return contratRepository.save(entity);
    }

    @Override
    public Contrat modifyContrat(Contrat entity) {
        return contratRepository.save(entity);
    }

    @Override
    public void removeContrat(Long id) {
        contratRepository.deleteById(id);
    }
}
