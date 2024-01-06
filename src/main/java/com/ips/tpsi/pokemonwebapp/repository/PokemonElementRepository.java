package com.ips.tpsi.pokemonwebapp.repository;

import com.ips.tpsi.pokemonwebapp.entity.PokemonElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PokemonElementRepository
		extends JpaRepository<PokemonElement, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId = :id")
	void deleteByPokemonId(@Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.elementId IN (" +
			"SELECT e.idElement FROM Element e WHERE e.elementDesc = :elementDesc)")
	void deleteByElement(@Param("elementDesc") String elementDesc);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.pokemonName = :name)")
	void deleteByPokemonName(@Param("name") String name);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.total = :total)")
	void deleteByTotal(@Param("total") Integer total);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.hp = :hp)")
	void deleteByHp(@Param("hp") Integer hp);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.attack = :attack)")
	void deleteByAttack(@Param("attack") Integer attack);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.defense = :defense)")
	void deleteByDefense(@Param("defense") Integer defense);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.speed = :speed)")
	void deleteBySpeed(@Param("speed") Integer speed);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.speedAttack = :speedAttack)")
	void deleteBySpeedAttack(@Param("speedAttack") Integer speedAttack);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.speedDefense = :speedDefense)")
	void deleteBySpeedDefense(@Param("speedDefense") Integer speedDefense);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.generation = :generation)")
	void deleteByGeneration(@Param("generation") Integer generation);

	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonElement pe WHERE pe.pokemonId IN (" +
			"SELECT p.idPokemon FROM Pokemon p WHERE p.legendary = :legendary)")
	void deleteByLegendary(@Param("legendary") String legendary);
}
