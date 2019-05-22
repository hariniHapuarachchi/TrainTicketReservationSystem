package rest.repository.custom.impl;

import org.springframework.stereotype.Repository;
import rest.entity.Payment;
import rest.repository.CrudRepositoryImpl;
import rest.repository.custom.PaymentRepository;

@Repository
public class PaymentRepositoryImpl extends CrudRepositoryImpl<Payment, Integer> implements PaymentRepository {
}
