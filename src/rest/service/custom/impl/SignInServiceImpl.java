package rest.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.SignInDTO;
import rest.repository.custom.SignInRepository;
import rest.service.Converter;
import rest.service.custom.SignInService;

import java.util.List;

@Service
@Transactional
public class SignInServiceImpl implements SignInService {

    private SignInRepository signInDAO;

    @Autowired
    public SignInServiceImpl(SignInRepository signInDAO) {
        this.signInDAO = signInDAO;
    }

    @Override
    public void createUser(SignInDTO dto) {
        signInDAO.save(Converter.getEntity(dto));
    }

    @Transactional(readOnly = true)
    public List<SignInDTO> getCustomers(){
        return signInDAO.findAll().map(Converter::<SignInDTO>getDTOList).get();
    }

    @Override
    public SignInDTO findUser(int id) {
        return signInDAO.find(id).map(Converter::<SignInDTO>getDTO).orElse(null);
    }

}
