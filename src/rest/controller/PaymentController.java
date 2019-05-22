package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.PaymentDTO;
import rest.service.custom.PaymentService;

import java.util.List;

@RequestMapping(value = "/api/v1/payments")
@CrossOrigin
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAllPayments() {
        List<PaymentDTO> payments = paymentService.getPayments();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", payments.size() + "");
        return new ResponseEntity<List<PaymentDTO>>(payments, httpHeaders, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity savePayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.savePayment(paymentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findPaymentDet(@PathVariable("id") int Id) {
        PaymentDTO paymentDTO = paymentService.findPayment(Id);
        HttpStatus status = (paymentDTO !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<PaymentDTO>(paymentDTO, status);
    }
}
