package rest.service.custom;

import rest.dto.ReservationDTO;
import rest.service.SuperService;

import java.util.List;

public interface ReservationService extends SuperService {

    void createReservation(ReservationDTO dto);

    List<ReservationDTO> getReservations();

    ReservationDTO findReservation(int id);
}
