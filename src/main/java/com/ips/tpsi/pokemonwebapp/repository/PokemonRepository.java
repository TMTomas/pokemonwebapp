package com.ips.tpsi.pokemonwebapp.repository;
import com.ips.tpsi.pokemonwebapp.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository
	extends JpaRepository<Pokemon, Long> { 
}
