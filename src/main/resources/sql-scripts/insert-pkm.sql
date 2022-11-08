DELETE FROM pokemon;
INSERT INTO pokemon  (number, name, height_in_meter, weight_in_kg, image_url, created) VALUES
(1,'Bulbasaur',0.1,6.9,'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png', DATE '2016-04-25'),
(2,'Ivysaur',1.0,13.0,'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/002.png', DATE '2016-04-25'),
(3,'Venusaur',2.0,100,'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/003.png', DATE '2016-04-25')
;


INSERT INTO language (iso_639_1,name) VALUES ('en','English'), ('fr','Français');


INSERT INTO localized_pkm (language_iso_639_1,pokemon_id,name) VALUES ('fr',1,'Bulbizarre');
INSERT INTO localized_pkm (language_iso_639_1,pokemon_id,name) VALUES ('en',1,'Bulbasaur');

INSERT INTO generation (number) VALUES (1), (2);
INSERT INTO localized_generation (language_iso_639_1,generation_number,display_name)
VALUES ('fr',1,'première generation'), ('en',1,'first generation');

INSERT INTO pkm_type (id, color_hex) VALUES (1,'000000'), (2,'000000'), (3,'000000');

INSERT INTO localized_pkm_type (pkm_type_id, language_iso_639_1, name) VALUES
(1,'en', 'poison'), (2,'en', 'grass'), (3,'en', 'psy'), (1,'fr', 'poison'), (2,'fr','plante');

INSERT INTO pkm_details (pokemon_id, generation_number) VALUES (1,1), (1,2);

INSERT INTO pkm_details_pkm_types (pkm_details_generation_number, pkm_details_pokemon_id,
 pkm_types_id ) VALUES (1,1,1), (1,1,2);


INSERT INTO localized_pkm_details (language_iso_639_1,pkm_details_generation_number,pkm_details_pokemon_id)
VALUES ('fr',1,1);

