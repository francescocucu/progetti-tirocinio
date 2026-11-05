SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE libri;
TRUNCATE TABLE generi;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO generi (id, nome) VALUES
  (1, 'Poesia'),
  (2, 'Giallo'),
  (3, 'Fantastico'),
  (4, 'Fantascienza'),
  (5, 'Horror'),
  (6, 'Storico'),
  (7, 'Biografia'),
  (8, 'Saggio'),
  (9, 'Avventura'),
  (10, 'Novelle'),
  (11, 'Psicologico'),
  (12, 'Formazione'),
  (13, 'Sentimentale'),
  (14, 'Realista'),
  (15, 'Satira'),
  (16, 'Realismo magico');
  
  insert into generi (id, nome) values
  (17, 'Fantasy');
  


INSERT INTO libri (id, titolo, id_genere, anno) VALUES
  (1, 'La Divina Commedia', 1, 1321),
  (2, 'Decameron', 10, 1353),
  (3, 'I promessi sposi', 6, 1827),
  (4, 'Canti', 1, 1831),
  (5, 'Il fu Mattia Pascal', 11, 1904),
  (6, 'Uno, nessuno e centomila', 11, 1926),
  (7, 'L''isola di Arturo', 12, 1957),
  (8, 'La Storia', 6, 1974),
  (9, 'Il barone rampante', 3, 1957),
  (10, 'Il visconte dimezzato', 3, 1952),
  (11, 'Il nome della rosa', 2, 1980),
  (12, 'Il pendolo di Foucault', 2, 1988),
  (13, 'Don Chisciotte della Mancia', 9, 1605),
  (14, 'Orgoglio e pregiudizio', 13, 1813),
  (15, 'Oliver Twist', 14, 1838),
  (16, 'Canto di Natale', 3, 1843),
  (17, 'Mrs Dalloway', 11, 1925),
  (18, '1984', 4, 1949),
  (19, 'La fattoria degli animali', 15, 1945),
  (20, 'I miserabili', 6, 1862),
  (21, 'Madame Bovary', 14, 1856),
  (22, 'Delitto e castigo', 11, 1866),
  (23, 'I fratelli Karamazov', 11, 1880),
  (24, 'Guerra e pace', 6, 1869),
  (25, 'Anna Karenina', 14, 1877),
  (26, 'Il vecchio e il mare', 9, 1952),
  (27, 'Cent''anni di solitudine', 16, 1967);
  
  insert into libri (titolo, id_genere,anno) values
  ('Lo Hobbit', 17, 1937),
  ('Il Signore degli Anelli', 17, 1954);
  
  
  
  

INSERT INTO autori (nome, cognome, data_nascita, nazionalita) VALUES
('Dante', 'Alighieri', '1265-05-21', 'italiana'),
('Giovanni', 'Boccaccio', '1313-06-16', 'italiana'),
('Alessandro', 'Manzoni', '1785-03-07', 'italiana'),
('Giacomo', 'Leopardi', '1798-06-29', 'italiana'),
('Luigi', 'Pirandello', '1867-06-28', 'italiana'),
('Elsa', 'Morante', '1912-08-18', 'italiana'),
('Italo', 'Calvino', '1923-10-15', 'italiana'),
('Umberto', 'Eco', '1932-01-05', 'italiana'),
('Miguel', 'de Cervantes', '1547-09-29', 'spagnola'),
('William', 'Shakespeare', '1564-04-23', 'inglese'),
('Jane', 'Austen', '1775-12-16', 'inglese'),
('Charles', 'Dickens', '1812-02-07', 'inglese'),
('Virginia', 'Woolf', '1882-01-25', 'inglese'),
('George', 'Orwell', '1903-06-25', 'inglese'),
('Victor', 'Hugo', '1802-02-26', 'francese'),
('Gustave', 'Flaubert', '1821-12-12', 'francese'),
('Fëdor', 'Dostoevskij', '1821-11-11', 'russa'),
('Lev', 'Tolstoj', '1828-09-09', 'russa'),
('Ernest', 'Hemingway', '1899-07-21', 'statunitense'),
('Gabriel', 'García Márquez', '1927-03-06', 'colombiana');

INSERT INTO case_editrici (nome) VALUES
('Mondadori'),
('Einaudi'),
('Feltrinelli'),
('Adelphi'),
('Garzanti'),
('Bompiani'),
('Rizzoli'),
('Laterza'),
('Sellerio'),
('Newton Compton'),
('Penguin Books'),
('Gallimard');


INSERT INTO libri_autori (id_libri, id_autori) VALUES
(1, 1),   -- La Divina Commedia → Dante
(2, 2),   -- Decameron → Boccaccio
(3, 3),   -- I promessi sposi → Manzoni
(4, 4),   -- Canti → Leopardi
(5, 5),   -- Il fu Mattia Pascal → Pirandello
(6, 5),   -- Uno, nessuno e centomila → Pirandello
(7, 6),   -- L'isola di Arturo → Morante
(8, 6),   -- La Storia → Morante
(9, 7),   -- Il barone rampante → Calvino
(10, 7),  -- Il visconte dimezzato → Calvino
(11, 8),  -- Il nome della rosa → Eco
(12, 8),  -- Il pendolo di Foucault → Eco
(13, 9),  -- Don Chisciotte → Cervantes
(14, 11), -- Orgoglio e pregiudizio → Austen
(15, 12), -- Oliver Twist → Dickens
(16, 12), -- Canto di Natale → Dickens
(17, 13), -- Mrs Dalloway → Woolf
(18, 14), -- 1984 → Orwell
(19, 14), -- La fattoria degli animali → Orwell
(20, 15), -- I miserabili → Hugo
(21, 16), -- Madame Bovary → Flaubert
(22, 17), -- Delitto e castigo → Dostoevskij
(23, 17), -- I fratelli Karamazov → Dostoevskij
(24, 18), -- Guerra e pace → Tolstoj
(25, 18), -- Anna Karenina → Tolstoj
(26, 19), -- Il vecchio e il mare → Hemingway
(27, 20); -- Cent'anni di solitudine → García Márquez

INSERT INTO copie (libri_id, case_editrici_id, numero_copie, is_disponibile) VALUES
(1, 2, 5, TRUE),
(1, 7, 3, TRUE),
(2, 2, 0, FALSE),
(3, 1, 12, TRUE),
(3, 5, 4, TRUE),
(4, 5, 2, TRUE),
(5, 1, 7, TRUE),
(6, 2, 0, FALSE),
(7, 2, 3, TRUE),
(8, 2, 1, TRUE),
(9, 1, 6, TRUE),
(10, 1, 0, FALSE),
(11, 6, 9, TRUE),
(11, 10, 2, TRUE),
(12, 6, 4, TRUE),
(13, 7, 1, TRUE),
(14, 10, 8, TRUE),
(14, 11, 3, TRUE),
(15, 3, 0, FALSE),
(16, 1, 5, TRUE),
(17, 3, 2, TRUE),
(18, 1, 10, TRUE),
(18, 11, 4, TRUE),
(19, 1, 6, TRUE),
(20, 7, 2, TRUE),
(20, 12, 1, TRUE),
(21, 3, 0, FALSE),
(22, 4, 5, TRUE),
(23, 2, 3, TRUE),
(24, 2, 2, TRUE),
(25, 4, 4, TRUE),
(26, 1, 7, TRUE),
(27, 1, 9, TRUE);

INSERT INTO copie (libri_id, case_editrici_id, numero_copie) VALUES
(28, 4, 13),
(29, 6, 1);

