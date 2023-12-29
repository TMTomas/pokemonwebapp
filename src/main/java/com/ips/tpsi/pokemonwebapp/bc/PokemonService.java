package com.ips.tpsi.pokemonwebapp.bc;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import com.ips.tpsi.pokemonwebapp.repository.PokemonRepository;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Iterable<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }

    public List<Object> getDetailedPokemons() {
        return pokemonRepository.findDetailedPokemons();
    }

    public Optional<Pokemon> getPokemon(final Integer id) {
        return pokemonRepository.findById(id);
    }

    public Object getDetailedPokemon(String pokemonName) {
        return pokemonRepository.findDetailedPokemonByName(pokemonName);
    }
    public Object getDetailedPokemon(Integer idPokemon) {
        return pokemonRepository.findDetailedPokemonByName(idPokemon);
    }

    public List<Object> getDetailedPokemonsByElement(String elementDesc) {
        return pokemonRepository.findDetailedPokemonsByElement(elementDesc);
    }

    public Pokemon savePokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public void deletePokemon(final Integer id) {
        pokemonRepository.deleteById(id);
    }
}