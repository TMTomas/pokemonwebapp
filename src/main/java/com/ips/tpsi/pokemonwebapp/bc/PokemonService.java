package com.ips.tpsi.pokemonwebapp.bc;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import com.ips.tpsi.pokemonwebapp.repository.PokemonRepository;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public Optional<Pokemon> getPokemon(final Integer id) {
        return pokemonRepository.findById(id);
    }

    public Iterable<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    public void deletePokemon(final Integer id) {
    	pokemonRepository.deleteById(id);
    }

    public Pokemon getPokemonInfoByName(String name) {
        return pokemonRepository.findPokemonBypokemonName(name);
    }
}