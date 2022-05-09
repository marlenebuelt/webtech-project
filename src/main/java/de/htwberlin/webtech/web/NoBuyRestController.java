package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.NoBuyService;
import de.htwberlin.webtech.web.api.NoBuy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoBuyRestController {

    private final NoBuyService noBuyService;

    public NoBuyRestController(NoBuyService noBuyService) {
        this.noBuyService = noBuyService;
    }

    @GetMapping(path = "/api/v1/nobuy")
    public ResponseEntity<List<NoBuy>> fetchNoBuy() {
        return ResponseEntity.ok(noBuyService.findAll());
    }
}
