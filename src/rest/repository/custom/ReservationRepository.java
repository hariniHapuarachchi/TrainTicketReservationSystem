package rest.repository.custom;

import rest.entity.Reservation;
import rest.entity.SignIn;
import rest.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, String> {
}
