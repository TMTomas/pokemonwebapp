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
@Table(name = "pokemon_element")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class pokemonElement {
    @Id
    @Column(name = "pokemon_id")
    private Integer pokemonId;

    @Id
    @Column(name = "element_id")
    private String elementId;

    @Column(name = "element_number")
    private Integer elementNumber;
}
