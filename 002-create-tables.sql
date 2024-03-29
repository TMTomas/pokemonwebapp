use pokemonproject;

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
    PRIMARY KEY (pokemon_id, element_id, element_number),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id_pokemon),
    FOREIGN KEY (element_id) REFERENCES element(id_element)
);