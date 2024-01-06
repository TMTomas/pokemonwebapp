create database pokemonproject;
use pokemonproject;


drop table pokemon_element;
drop table element;
drop table pokemon;

-- Create Pokemon table
CREATE TABLE pokemon (
    id_pokemon INT AUTO_INCREMENT PRIMARY KEY,
    pokemon_name VARCHAR(255) NOT NULL,
    total INT NOT NULL,
    hp INT NOT NULL,
    attack INT NOT NULL,
    defense INT NOT NULL,
    speed INT NOT NULL,
    speed_attack INT NOT NULL,
    speed_defense INT NOT NULL,
    generation INT NOT NULL,
    legendary varchar(255) NOT NULL
);

-- Create Element table
CREATE TABLE element (
    id_element INT AUTO_INCREMENT PRIMARY KEY,
    element_desc VARCHAR(255) NOT NULL
);

-- Create Pokemon_Element table (Associative table)
CREATE TABLE pokemon_element (
    pokemon_id INT NOT NULL,
    element_id INT NOT NULL,
    element_number INT,
    PRIMARY KEY (pokemon_id, element_id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id_pokemon),
    FOREIGN KEY (element_id) REFERENCES element(id_element)
);


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

SELECT p.*, e1.element_desc as type1, e2.element_desc as type2 
FROM pokemon p
INNER JOIN pokemon_element pe1 ON p.id_pokemon = pe1.pokemon_id AND pe1.element_number = 1
INNER JOIN element e1 ON pe1.element_id = e1.id_element 
LEFT JOIN pokemon_element pe2 ON p.id_pokemon = pe2.pokemon_id AND pe2.element_number = 2 
LEFT JOIN element e2 ON pe2.element_id = e2.id_element;
