package rest.service.custom;

import rest.dto.PaymentDTO;
import rest.dto.ReservationDTO;
import rest.service.SuperService;

import java.util.List;

public interface PaymentService extends SuperService {

    void savePayment(PaymentDTO dto);

    List<PaymentDTO> getPayments();

    PaymentDTO findPayment(int id);
}
