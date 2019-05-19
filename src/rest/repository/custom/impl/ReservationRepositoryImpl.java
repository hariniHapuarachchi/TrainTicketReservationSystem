package rest.repository.custom.impl;

import org.springframework.stereotype.Repository;
import rest.entity.Reservation;
import rest.entity.SignIn;
import rest.repository.CrudRepositoryImpl;
import rest.repository.custom.ReservationRepository;

@Repository
public class ReservationRepositoryImpl extends CrudRepositoryImpl<Reservation, String> implements ReservationRepository {
}
