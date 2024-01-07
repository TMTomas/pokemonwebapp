SELECT p.*, e1.element_desc as type1, e2.element_desc as type2 
FROM pokemon p
INNER JOIN pokemon_element pe1 ON p.id_pokemon = pe1.pokemon_id AND pe1.element_number = 1
INNER JOIN element e1 ON pe1.element_id = e1.id_element 
LEFT JOIN pokemon_element pe2 ON p.id_pokemon = pe2.pokemon_id AND pe2.element_number = 2 
LEFT JOIN element e2 ON pe2.element_id = e2.id_element
order by id_pokemon;