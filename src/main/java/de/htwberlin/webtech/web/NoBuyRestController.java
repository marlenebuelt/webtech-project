package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.NoBuyService;
import de.htwberlin.webtech.web.api.NoBuy;
import de.htwberlin.webtech.web.api.NoBuyManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    @GetMapping(path = "/api/v1/nobuy/{id}")
    public ResponseEntity<NoBuy> fetchNoBuyById(@PathVariable Long id){
        var noBuy = noBuyService.findbyId(id);
        return noBuy != null? ResponseEntity.ok(noBuy) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/nobuy")
    public ResponseEntity<Void> createNoBuy(@RequestBody NoBuyManipulationRequest request) throws URISyntaxException {
        var noBuy = noBuyService.create(request);
        URI uri = new URI("/api/v1/nobuy" + noBuy.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/nobuy{id}")
        public ResponseEntity<NoBuy> updateNoBuy(@PathVariable Long id, @RequestBody NoBuyManipulationRequest request){
        var noBuy = noBuyService.update(id, request);
        return noBuy != null? ResponseEntity.ok(noBuy) : ResponseEntity.notFound().build();
    }
}
