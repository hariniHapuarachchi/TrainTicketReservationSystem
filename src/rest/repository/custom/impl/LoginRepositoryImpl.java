package rest.repository.custom.impl;

import org.springframework.stereotype.Repository;
import rest.entity.Login;
import rest.entity.Reservation;
import rest.repository.CrudRepositoryImpl;
import rest.repository.custom.LoginRepository;
import rest.repository.custom.ReservationRepository;

@Repository
public class LoginRepositoryImpl extends CrudRepositoryImpl<Login, String > implements LoginRepository {
}
