package rest.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.PaymentDTO;
import rest.repository.custom.PaymentRepository;
import rest.service.Converter;
import rest.service.custom.PaymentService;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentDAO;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public void savePayment(PaymentDTO dto) {
        paymentDAO.save(Converter.getEntity(dto));
    }

    @Override
    public List<PaymentDTO> getPayments() {
        return paymentDAO.findAll().map(Converter::<PaymentDTO>getDTOList).get();
    }

    @Override
    public PaymentDTO findPayment(int id) {
        return paymentDAO.find(id).map(Converter::<PaymentDTO>getDTO).orElse(null);
    }
}
