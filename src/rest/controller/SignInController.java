package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.SignInDTO;
import rest.service.custom.SignInService;

import java.util.List;

@RequestMapping(value = "/api/v1/users")
@CrossOrigin
@RestController
public class SignInController {

    @Autowired
    private SignInService signInService;

    @GetMapping
    public ResponseEntity<List<SignInDTO>> findAllCustomers() {
        List<SignInDTO> customers = signInService.getCustomers();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count", customers.size() + "");
        return new ResponseEntity<List<SignInDTO>>(customers, httpHeaders, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveUsers(@RequestBody SignInDTO user) {
        signInService.createUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

}
