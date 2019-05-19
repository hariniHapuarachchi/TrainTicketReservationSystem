package rest.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.ReservationDTO;
import rest.dto.SignInDTO;
import rest.repository.custom.ReservationRepository;
import rest.repository.custom.SignInRepository;
import rest.service.Converter;
import rest.service.custom.ReservationService;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationDAO;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public void createReservation(ReservationDTO dto) {
        reservationDAO.save(Converter.getEntity(dto));
    }

    @Transactional(readOnly = true)
    public List<ReservationDTO> getReservations() {
        return reservationDAO.findAll().map(Converter::<ReservationDTO>getDTOList).get();
    }

    @Override
    public ReservationDTO findReservation(String id) {
        return reservationDAO.find(id).map(Converter::<ReservationDTO>getDTO).orElse(null);
    }
}
