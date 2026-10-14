package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe retrieveEmploye(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public Employe addEmploye(Employe entity) {
        return employeRepository.save(entity);
    }

    @Override
    public Employe modifyEmploye(Employe entity) {
        return employeRepository.save(entity);
    }

    @Override
    public void removeEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}
