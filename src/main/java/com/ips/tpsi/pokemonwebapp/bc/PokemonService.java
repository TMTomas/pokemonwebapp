package com.ips.tpsi.pokemonwebapp.bc;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import com.ips.tpsi.pokemonwebapp.repository.PokemonElementRepository;
import com.ips.tpsi.pokemonwebapp.repository.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonElementRepository pokemonElementRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, PokemonElementRepository pokemonElementRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonElementRepository = pokemonElementRepository;
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

    public List<Object> getDetailedPokemonsBySpeedDefense(int speedDefense) {
        return pokemonRepository.findDetailedPokemonsBySpeedDefense(speedDefense);
    }

    public List<Object> getDetailedPokemonsByGeneration(int generation) {
        return pokemonRepository.findDetailedPokemonsByGeneration(generation);
    }

    public List<Object> getDetailedPokemonsByLegendary(String legendary) {
        return pokemonRepository.findDetailedPokemonsByLegendary(legendary);
    }

    public void deletePokemonById(final Integer idPokemon) {
        pokemonElementRepository.deleteByPokemonId(idPokemon);
        pokemonRepository.deleteById(idPokemon);
    }

    public void deletePokemonByName(String pokemonName) {
        pokemonElementRepository.deleteByPokemonName(pokemonName);
        pokemonRepository.deleteByName(pokemonName);
    }

    public void deletePokemonByElement(String elementDesc) {
        pokemonElementRepository.deleteByElement(elementDesc);
        pokemonRepository.deleteByElement(elementDesc);
    }

    public void deletePokemonByTotal(int total) {
        pokemonElementRepository.deleteByTotal(total);
        pokemonRepository.deleteByTotal(total);
    }

    public void deletePokemonByHp(int hp) {
        pokemonElementRepository.deleteByHp(hp);
        pokemonRepository.deleteByHp(hp);
    }

    public void deletePokemonByAttack(int attack) {
        pokemonElementRepository.deleteByAttack(attack);
        pokemonRepository.deleteByAttack(attack);
    }

    public void deletePokemonByDefense(int defense) {
        pokemonElementRepository.deleteByDefense(defense);
        pokemonRepository.deleteByDefense(defense);
    }

    public void deletePokemonBySpeed(int speed) {
        pokemonElementRepository.deleteBySpeed(speed);
        pokemonRepository.deleteBySpeed(speed);
    }

    public void deletePokemonBySpeedAttack(int speedAttack) {
        pokemonElementRepository.deleteBySpeedAttack(speedAttack);
        pokemonRepository.deleteBySpeedAttack(speedAttack);
    }

    public void deletePokemonBySpeedDefense(int speedDefense) {
        pokemonElementRepository.deleteBySpeedDefense(speedDefense);
        pokemonRepository.deleteBySpeedDefense(speedDefense);
    }

    public void deletePokemonByGeneration(int generation) {
        pokemonElementRepository.deleteByGeneration(generation);
        pokemonRepository.deleteByGeneration(generation);
    }

    public void deletePokemonByLegendary(String legendary) {
        pokemonElementRepository.deleteByLegendary(legendary);
        pokemonRepository.deleteByLegendary(legendary);
    }

}