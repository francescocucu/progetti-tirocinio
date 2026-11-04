-- Mostrare tutti gli autori ordinati per cognome e poi per nome.
select * 
from autore
order by autore.cognome, autore.nome; 

-- Mostrare titolo e anno dei libri pubblicati dopo il 2000.
select titolo, anno
from libri
where anno > 2000;

-- Trovare gli autori italiani.
select * 
from autore
where nazionalita = 'italiana';

-- Trovare i libri il cui titolo contiene la parola "x" (senza distinguere maiuscole e minuscole).
select *
from libri
where titolo like '%o%'; 

-- Elencare le case editrici presenti, senza duplicati.
select distinct nome
from case_editrici;

-- Mostrare i 5 libri più recenti.
select *
from libri
order by anno desc
limit 5;

-- Mostrare ogni libro con il nome del suo genere.
select libri.titolo, generi.nome
from libri
join generi on libri.id_genere = generi.id;

-- Mostrare ogni libro con nome e cognome dei suoi autori (passando da libro_autore).
select libri.titolo, autore.nome, autore.cognome
from libri
join libri_autore on libri.id = libri_autore.id_libri
join autore on libri_autore.id_autore = autore.id;

-- Trovare tutti i libri scritti da un autore dato il suo cognome.
select libri.titolo 
from libri
join libri_autore on libri.id = libri_autore.id_libri
join autore on libri_autore.id_autore = autore.id
where autore.cognome = 'Pirandello';

-- Trovare i libri di genere "Fantasy" che hanno almeno una copia disponibile.
select libri.titolo, generi.nome, copie.numero_copie
from libri
join generi on libri.id_genere = generi.id
join copie on libri.id = copie.libri_id
where generi.nome = 'Fantasy' and copie.numero_copie >0;

-- Mostrare gli autori che hanno scritto almeno un libro di un certo genere, senza duplicati.

select distinct autore.nome, autore.cognome
from libri
join generi on libri.id_genere = generi.id
join libri_autore on libri.id = libri_autore.id_libri
join autore on libri_autore.id_autore = autore.id
where generi.nome = 'Storico';

