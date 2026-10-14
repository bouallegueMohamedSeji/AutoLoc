package tn.esprit.autoloc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation entity) {
        return reservationRepository.save(entity);
    }

    @Override
    public Reservation modifyReservation(Reservation entity) {
        return reservationRepository.save(entity);
    }

    @Override
    public void removeReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
