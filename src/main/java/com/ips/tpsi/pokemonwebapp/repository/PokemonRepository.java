package com.ips.tpsi.pokemonwebapp.repository;

import com.ips.tpsi.pokemonwebapp.entity.Pokemon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository
                extends JpaRepository<Pokemon, Integer> {

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement")
        List<Object> findDetailedPokemons();

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.pokemonName = :pokemonName")
        Object findDetailedPokemonByName(String pokemonName);


        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE e1.elementDesc = :elementDesc OR e2.elementDesc = :elementDesc")
        List<Object> findDetailedPokemonsByElement(String elementDesc);

}
