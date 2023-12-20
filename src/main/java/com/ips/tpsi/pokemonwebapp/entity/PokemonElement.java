package com.ips.tpsi.pokemonwebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pokemon_element")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@IdClass(PokemonElementId.class)
public class PokemonElement {

    @Id
    @Column(name = "pokemon_id")
    private Integer pokemonId;

    @Id
    @Column(name = "element_id")
    private Integer elementId;

    @Column(name = "element_number")
    private Integer elementNumber;
}