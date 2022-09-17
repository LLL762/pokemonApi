DELETE FROM pokemon;
INSERT INTO pokemon  (number, name, height_in_meter, weight_in_kg, image_url, created) VALUES
(1,'Bulbasaur',0.1,6.9,'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png', DATE '2016-04-25'),
(2,'Ivysaur',1.0,13.0,'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/002.png', DATE '2016-04-25'),
(3,'Venusaur',2.0,100,'https://assets.pokemon.com/assets/cms2/img/pokedex/detail/003.png', DATE '2016-04-25')
;


INSERT INTO language (iso_639_1,name) VALUES ('en','English'), ('fr','Français');


INSERT INTO localized_pkm (language_iso_639_1,pokemon_id,name) VALUES ('fr',1,'Bulbizarre');
INSERT INTO localized_pkm (language_iso_639_1,pokemon_id,name) VALUES ('en',1,'Bulbasaur');



