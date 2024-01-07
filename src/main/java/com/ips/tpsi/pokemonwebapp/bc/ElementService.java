package com.ips.tpsi.pokemonwebapp.bc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ips.tpsi.pokemonwebapp.entity.Element;
import com.ips.tpsi.pokemonwebapp.repository.ElementRepository;

@Service
public class ElementService {
    @Autowired
    private ElementRepository elementRepository;

    @Autowired
    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public Iterable<Element> getElements() {
        return elementRepository.findAll();
    }

    public boolean isElementExists(String elementDesc) {
        return elementRepository.existsByElementDesc(elementDesc);
    }
}