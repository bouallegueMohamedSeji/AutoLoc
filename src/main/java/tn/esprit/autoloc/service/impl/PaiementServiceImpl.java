package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement retrievePaiement(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public Paiement addPaiement(Paiement entity) {
        return paiementRepository.save(entity);
    }

    @Override
    public Paiement modifyPaiement(Paiement entity) {
        return paiementRepository.save(entity);
    }

    @Override
    public void removePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}
