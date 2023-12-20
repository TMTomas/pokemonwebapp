package com.ips.tpsi.pokemonwebapp.entity;

import java.io.Serializable;
import java.util.Objects;

public class PokemonElementId implements Serializable {

    // Atributos

    public Integer pokemonId;
    public Integer elementId;

    // Construtores

    public PokemonElementId() {
    }

    public PokemonElementId(Integer pokemonId, Integer elementId) {
        this.pokemonId = pokemonId;
        this.elementId = elementId;
    }

    // Getters e setters

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    // Metodos complementares

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonElementId that = (PokemonElementId) o;
        return Objects.equals(pokemonId, that.pokemonId) &&
               Objects.equals(elementId, that.elementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, elementId);
    }
}
