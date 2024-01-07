INSERT INTO element (element_desc)
SELECT DISTINCT `Type 1` from pokemon_csv
UNION
SELECT "";

INSERT INTO pokemon (pokemon_name, total, hp, attack, defense, speed, speed_attack, speed_defense, generation, legendary)
SELECT `Name`, `Total`, `HP`, `Attack`, `Defense`, `Speed`, `Sp. Atk`, `Sp. Def`, `Generation`, `Legendary` from pokemon_csv;

-- Atualizar a tabela pokemon_element com os dados do arquivo pokemon_csv
INSERT INTO pokemon_element (pokemon_id, element_id, element_number)
SELECT id_pokemon, id_element, 1 from pokemon_csv
INNER JOIN element on element_desc = `Type 1`
INNER JOIN pokemon on pokemon_name = `Name`;


-- Inserir dados para Tipo 2
INSERT INTO pokemon_element (pokemon_id, element_id, element_number)
SELECT id_pokemon, id_element, 2 from pokemon_csv
INNER JOIN element on element_desc = `Type 2`
INNER JOIN pokemon on pokemon_name = `Name`;