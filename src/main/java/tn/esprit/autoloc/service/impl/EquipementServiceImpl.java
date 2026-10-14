package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement retrieveEquipement(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public Equipement addEquipement(Equipement entity) {
        return equipementRepository.save(entity);
    }

    @Override
    public Equipement modifyEquipement(Equipement entity) {
        return equipementRepository.save(entity);
    }

    @Override
    public void removeEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}
