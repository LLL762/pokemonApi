
INSERT INTO generation (number, pkm_stats_schema) VALUES
(1, '{"name" : "robert"}' FORMAT JSON), (2, '{"name" : "robert"}' FORMAT JSON);

INSERT INTO localized_generation (language_iso_639_1,generation_number,display_name, description)
VALUES ('fr',1,'première generation', 'une description'), ('en',1,'first generation','a description');


