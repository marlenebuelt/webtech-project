package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistance.NoBuyEntity;
import de.htwberlin.webtech.persistance.NoBuyRepository;
import de.htwberlin.webtech.web.api.NoBuy;
import de.htwberlin.webtech.web.api.NoBuyManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoBuyService {

    private final NoBuyRepository noBuyRepository;

    public NoBuyService(NoBuyRepository noBuyRepository) {
        this.noBuyRepository = noBuyRepository;
    }

    public List<NoBuy> findAll() {
        List<NoBuyEntity> noBuy = noBuyRepository.findAll();
        return noBuy.stream()
                .map(noBuyEntity -> transformEntity(noBuyEntity))
                .collect(Collectors.toList());
    }

    public NoBuy findbyId(Long id) {
        var noBuyEntity = noBuyRepository.findById(id);
        return noBuyEntity.isPresent() ? transformEntity(noBuyEntity.get()) : null;
    }

    public NoBuy create(NoBuyManipulationRequest request) {
        var noBuyEntity = new NoBuyEntity(request.getCategory(), request.getDescription(), request.getValue());
        noBuyEntity = noBuyRepository.save(noBuyEntity);
        return transformEntity(noBuyEntity);
    }

    public NoBuy update(Long id, NoBuyManipulationRequest request) {
        var noBuyEntityOptional = noBuyRepository.findById(id);
        if (noBuyEntityOptional.isEmpty()) {
            return null;
        }
        var noBuyEntity = noBuyEntityOptional.get();
        noBuyEntity.setCategory(request.getCategory());
        noBuyEntity.setDescription(request.getDescription());
        noBuyEntity.setValue(request.getValue());
        noBuyEntity = noBuyRepository.save(noBuyEntity);

        return transformEntity(noBuyEntity);
    }

    public boolean deleteById(Long id) {
        if (!noBuyRepository.existsById(id)) {
            return false;
        }
        noBuyRepository.deleteById(id);
        return false;
    }

    private NoBuy transformEntity(NoBuyEntity noBuyEntity) {
        return new NoBuy(
                noBuyEntity.getId(),
                noBuyEntity.getCategory(),
                noBuyEntity.getDescription(),
                noBuyEntity.getValue()
        );
    }
}
