package rest.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.LoginDTO;
import rest.repository.custom.LoginRepository;
import rest.service.Converter;
import rest.service.custom.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    private LoginRepository loginDAO;

    @Autowired
    public LoginServiceImpl(LoginRepository loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public void saveLoginDet(LoginDTO dto) {
        loginDAO.save(Converter.getEntity(dto));
    }

    @Override
    public void updateLoginDet(LoginDTO dto) {
        loginDAO.update(Converter.getEntity(dto));
    }
}
