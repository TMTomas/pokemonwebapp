package com.ips.tpsi.pokemonwebapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Pokemon {

    @Id
    @Column(name = "id_pokemon")
    private Integer idPokemon;

    @Column(name = "pokemon_name")
    private String pokemonName;

    @Column(name = "total")
    private Integer total;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "speed_attack")
    private Integer speed_attack;

    @Column(name = "speed_defense")
    private Integer speed_defense;

    @Column(name = "generation")
    private Integer generation;

    @Column(name = "legendary")
    private String legendary;
}
