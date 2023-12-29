package com.ips.tpsi.pokemonwebapp.bc;

import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ips.tpsi.pokemonwebapp.entity.Element;
import com.ips.tpsi.pokemonwebapp.repository.ElementRepository;

import java.util.Optional;

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

    public Optional<Element> getElement(final Integer id) {
        return elementRepository.findById(id);
    }

    public Element getElement(String elementName){
        return elementRepository.findbyName(elementName);
    }

    public Element saveElement(Element element) {
        return elementRepository.save(element);
    }

    public void deleteElement(final Integer id) {
        elementRepository.deleteById(id);
    }
}