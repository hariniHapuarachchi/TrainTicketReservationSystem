package rest.service.custom;

import rest.dto.LoginDTO;
import rest.service.SuperService;

import java.util.List;

public interface LoginService extends SuperService {

    void saveLoginDet(LoginDTO dto);

    void updateLoginDet(LoginDTO dto);

    List<LoginDTO> getLogins();

    LoginDTO findLoginDet(String id);

}
