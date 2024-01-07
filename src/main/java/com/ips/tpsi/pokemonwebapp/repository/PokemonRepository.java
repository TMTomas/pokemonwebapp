package com.ips.tpsi.pokemonwebapp.repository;

import com.ips.tpsi.pokemonwebapp.entity.Pokemon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PokemonRepository
                extends JpaRepository<Pokemon, Integer> {

        // CONSULTAR

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
                        "WHERE p.idPokemon = :idPokemon")
        Object findDetailedPokemonById(final Integer idPokemon);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.pokemonName = :pokemonName")
        Object findDetailedPokemonByName(@Param("pokemonName") String pokemonName);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE e1.elementDesc = :elementDesc OR e2.elementDesc = :elementDesc")
        List<Object> findDetailedPokemonsByElement(String elementDesc);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.total = :total")
        List<Object> findDetailedPokemonsByTotal(int total);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.hp = :hp")
        List<Object> findDetailedPokemonsByHp(int hp);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.attack = :attack")
        List<Object> findDetailedPokemonsByAttack(int attack);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.defense = :defense")
        List<Object> findDetailedPokemonsByDefense(int defense);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.speed = :speed")
        List<Object> findDetailedPokemonsBySpeed(int speed);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.speedAttack = :speedAttack")
        List<Object> findDetailedPokemonsBySpeedAttack(int speedAttack);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.speedDefense = :speedDefense")
        List<Object> findDetailedPokemonsBySpeedDefense(int speedDefense);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.generation = :generation")
        List<Object> findDetailedPokemonsByGeneration(int generation);

        @Query("SELECT p, e1.elementDesc as type1, e2.elementDesc as type2 " +
                        "FROM Pokemon p " +
                        "INNER JOIN PokemonElement pe1 ON p.idPokemon = pe1.pokemonId AND pe1.elementNumber = 1 " +
                        "INNER JOIN Element e1 ON pe1.elementId = e1.idElement " +
                        "LEFT JOIN PokemonElement pe2 ON p.idPokemon = pe2.pokemonId AND pe2.elementNumber = 2 " +
                        "LEFT JOIN Element e2 ON pe2.elementId = e2.idElement " +
                        "WHERE p.legendary = :legendary")
        List<Object> findDetailedPokemonsByLegendary(String legendary);

        // APAGAR

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.idPokemon = :id")
        void deleteById(@Param("id") Integer id);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.pokemonName = :name")
        void deleteByName(@Param("name") String name);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.total = :total")
        void deleteByTotal(@Param("total") Integer total);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.hp = :hp")
        void deleteByHp(@Param("hp") Integer hp);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.attack = :attack")
        void deleteByAttack(@Param("attack") Integer attack);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.defense = :defense")
        void deleteByDefense(@Param("defense") Integer defense);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.speed = :speed")
        void deleteBySpeed(@Param("speed") Integer speed);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.speedAttack = :speedAttack")
        void deleteBySpeedAttack(@Param("speedAttack") Integer speedAttack);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.speedDefense = :speedDefense")
        void deleteBySpeedDefense(@Param("speedDefense") Integer speedDefense);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.generation = :generation")
        void deleteByGeneration(@Param("generation") Integer generation);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.legendary = :legendary")
        void deleteByLegendary(@Param("legendary") String legendary);

        @Transactional
        @Modifying
        @Query("DELETE FROM Pokemon p WHERE p.idPokemon IN (" +
                        "SELECT pe.pokemonId FROM PokemonElement pe WHERE pe.elementId IN (" +
                        "SELECT e.idElement FROM Element e WHERE e.elementDesc = :elementDesc))")
        void deleteByElement(@Param("elementDesc") String elementDesc);

        // ALTERAR
        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.pokemonName = :newName WHERE p.idPokemon = :id")
        void updatePokemonName(@Param("id") Integer id, @Param("newName") String newName);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.total = :newTotal WHERE p.idPokemon = :id")
        void updatePokemonTotal(@Param("id") Integer id, @Param("newTotal") Integer newTotal);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.hp = :newHp WHERE p.idPokemon = :id")
        void updatePokemonHp(@Param("id") Integer id, @Param("newHp") Integer newHp);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.attack = :newAttack WHERE p.idPokemon = :id")
        void updatePokemonAttack(@Param("id") Integer id, @Param("newAttack") Integer newAttack);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.defense = :newDefense WHERE p.idPokemon = :id")
        void updatePokemonDefense(@Param("id") Integer id, @Param("newDefense") Integer newDefense);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.speed = :newSpeed WHERE p.idPokemon = :id")
        void updatePokemonSpeed(@Param("id") Integer id, @Param("newSpeed") Integer newSpeed);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.speedAttack = :newSpeedAttack WHERE p.idPokemon = :id")
        void updatePokemonSpeedAttack(@Param("id") Integer id, @Param("newSpeedAttack") Integer newSpeedAttack);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.speedDefense = :newSpeedDefense WHERE p.idPokemon = :id")
        void updatePokemonSpeedDefense(@Param("id") Integer id, @Param("newSpeedDefense") Integer newSpeedDefense);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.generation = :newGeneration WHERE p.idPokemon = :id")
        void updatePokemonGeneration(@Param("id") Integer id, @Param("newGeneration") Integer newGeneration);

        @Transactional
        @Modifying
        @Query("UPDATE Pokemon p SET p.legendary = :newLegendary WHERE p.idPokemon = :id")
        void updatePokemonLegendary(@Param("id") Integer id, @Param("newLegendary") String newLegendary);

}