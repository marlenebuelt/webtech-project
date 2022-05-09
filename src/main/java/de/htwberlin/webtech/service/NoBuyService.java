package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistance.NoBuyEntity;
import de.htwberlin.webtech.persistance.NoBuyRepository;
import de.htwberlin.webtech.web.api.NoBuy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoBuyService {

    private final NoBuyRepository noBuyRepository;

    public NoBuyService(NoBuyRepository noBuyRepository) {
        this.noBuyRepository = noBuyRepository;
    }
    public List<NoBuy> findAll(){
        List<NoBuyEntity> noBuy = noBuyRepository.findAll();
        return noBuy.stream().map(noBuyEntity -> new NoBuy(
                noBuyEntity.getId(),
                noBuyEntity.getCategory(),
                noBuyEntity.getDescription(),
                noBuyEntity.getValue()
        )).collect(Collectors.toList());
    }
}
