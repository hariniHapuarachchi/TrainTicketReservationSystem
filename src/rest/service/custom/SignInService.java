package rest.service.custom;

import rest.dto.SignInDTO;
import rest.service.SuperService;

import java.util.List;

public interface SignInService extends SuperService {


    void createUser(SignInDTO dto);

    List<SignInDTO> getCustomers();

}
