package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.LoginDTO;
import rest.dto.ReservationDTO;
import rest.service.custom.LoginService;

@RequestMapping(value = "/api/v1/logins")
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveReservations(@RequestBody LoginDTO loginDTO) {
        loginService.saveLoginDet(loginDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable("id") String logTime,
                                         @RequestBody LoginDTO login) {
        if (logTime.equals(login.getLoginTime())) {
            loginService.updateLoginDet(login);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
