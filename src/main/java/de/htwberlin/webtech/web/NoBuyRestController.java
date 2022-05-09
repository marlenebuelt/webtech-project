package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.NoBuy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NoBuyRestController {

    private List<NoBuy> noBuyList;

    public NoBuyRestController(){
        noBuyList = new ArrayList<>();
        noBuyList.add(new NoBuy(1, "Sport", "Ball", 30));
        noBuyList.add(new NoBuy(2, "Clothing", "Shirt", 20));

    }

    @GetMapping(path = "/api/v1/nobuy")
    public ResponseEntity<List<NoBuy>> fetchNoBuy(){
        return ResponseEntity.ok(noBuyList);
    }
}
