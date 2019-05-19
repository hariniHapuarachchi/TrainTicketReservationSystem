package rest.service.custom;

import rest.dto.LoginDTO;
import rest.service.SuperService;

public interface LoginService extends SuperService {

    void saveLoginDet(LoginDTO dto);

    void updateLoginDet(LoginDTO dto);
}
