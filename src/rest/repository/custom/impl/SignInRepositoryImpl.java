package rest.repository.custom.impl;

import org.springframework.stereotype.Repository;
import rest.entity.SignIn;
import rest.repository.CrudRepositoryImpl;
import rest.repository.custom.SignInRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class SignInRepositoryImpl extends CrudRepositoryImpl<SignIn, String> implements SignInRepository {

}
