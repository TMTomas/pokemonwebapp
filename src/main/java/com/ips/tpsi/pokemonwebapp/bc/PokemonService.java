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

    public Optional<Pokemon> getPokemonById(final Integer id) {
        return pokemonRepository.findById(id);
    }

    public Object getDetailedPokemonById(final Integer idPokemon) {
        return pokemonRepository.findDetailedPokemonById(idPokemon);
    }

    public Object getDetailedPokemonByName(String pokemonName) {
        return pokemonRepository.findDetailedPokemonByName(pokemonName);
    }

    public List<Object> getDetailedPokemonsByElement(String elementDesc) {
        return pokemonRepository.findDetailedPokemonsByElement(elementDesc);
    }

    public List<Object> getDetailedPokemonsByTotal(int total) {
        return pokemonRepository.findDetailedPokemonsByTotal(total);
    }

    public List<Object> getDetailedPokemonsByHp(int hp) {
        return pokemonRepository.findDetailedPokemonsByHp(hp);
    }

    public List<Object> getDetailedPokemonsByAttack(int attack) {
        return pokemonRepository.findDetailedPokemonsByAttack(attack);
    }

    public List<Object> getDetailedPokemonsByDefense(int defense) {
        return pokemonRepository.findDetailedPokemonsByDefense(defense);
    }

    public List<Object> getDetailedPokemonsBySpeed(int speed) {
        return pokemonRepository.findDetailedPokemonsBySpeed(speed);
    }
    public List<Object> getDetailedPokemonsBySpeedAttack(int speedAttack) {
        return pokemonRepository.findDetailedPokemonsBySpeedAttack(speedAttack);
    }
    public List<Object> getDetailedPokemonsBySpeedDefense(int speepDefense) {
        return pokemonRepository.findDetailedPokemonsBySpeedDefense(speepDefense);
    }

    public List<Object> getDetailedPokemonsByGeneration(int generation) {
        return pokemonRepository.findDetailedPokemonsByGeneration(generation);
    }

    public List<Object> getDetailedPokemonsByLegendary(String legendary) {
        return pokemonRepository.findDetailedPokemonsByLegendary(legendary);
    }

    public void deletePokemonById(final Integer id) {
        pokemonRepository.deleteById(id);
    }
}