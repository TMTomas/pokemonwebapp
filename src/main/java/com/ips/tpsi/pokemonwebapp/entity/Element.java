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
@Table(name = "element")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Element {
    @Id
    @Column(name = "id_element")
    private Integer idElement;

    @Column(name = "element_desc")
    private String elementDesc;

}
