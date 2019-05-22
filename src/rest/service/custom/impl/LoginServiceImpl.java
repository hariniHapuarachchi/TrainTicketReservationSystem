package rest.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.LoginDTO;
import rest.repository.custom.LoginRepository;
import rest.service.Converter;
import rest.service.custom.LoginService;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<LoginDTO> getLogins() {
        return loginDAO.findAll().map(Converter::<LoginDTO>getDTOList).get();
    }

    @Override
    public LoginDTO findLoginDet(String id) {
        return loginDAO.find(id).map(Converter::<LoginDTO>getDTO).orElse(null);
    }
}
