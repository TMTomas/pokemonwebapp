package com.ips.tpsi.pokemonwebapp.repository;

import com.ips.tpsi.pokemonwebapp.entity.Element;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {

    @Query("SELECT COUNT(e) > 0 FROM Element e WHERE e.elementDesc = :elementDesc")
    boolean existsByElementDesc(@Param("elementDesc") String elementDesc);

}
