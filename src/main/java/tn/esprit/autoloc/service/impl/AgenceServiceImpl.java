package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveAgence(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public Agence addAgence(Agence entity) {
        return agenceRepository.save(entity);
    }

    @Override
    public Agence modifyAgence(Agence entity) {
        return agenceRepository.save(entity);
    }

    @Override
    public void removeAgence(Long id) {
        agenceRepository.deleteById(id);
    }
}
