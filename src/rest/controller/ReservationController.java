package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.ReservationDTO;
import rest.dto.SignInDTO;
import rest.service.custom.ReservationService;
import rest.service.custom.SignInService;

import java.util.List;

@RequestMapping(value = "/api/v1/reservations")
@CrossOrigin
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        List<ReservationDTO> reservations = reservationService.getReservations();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", reservations.size() + "");
        return new ResponseEntity<List<ReservationDTO>>(reservations, httpHeaders, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveReservations(@RequestBody ReservationDTO reservationDTO) {
        reservationService.createReservation(reservationDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findReservation(@PathVariable("id") int Id) {
        ReservationDTO reservationDTO = reservationService.findReservation(Id);
        HttpStatus status = (reservationDTO !=null)? HttpStatus.OK: HttpStatus.NOT_FOUND;
        return new ResponseEntity<ReservationDTO>(reservationDTO, status);
    }
}
