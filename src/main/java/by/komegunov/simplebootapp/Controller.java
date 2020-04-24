package by.komegunov.simplebootapp;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final ClientRepository clientRepository;

    public Controller(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("get")

    public List<Client> doGet(@RequestParam(required = false, defaultValue = "0") Integer page) {
        List<Client> clientRep = clientRepository.findAll(PageRequest.of(page,5)).getContent();
        return clientRep;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onException() {
        return "Wrong page number";
    }
}
