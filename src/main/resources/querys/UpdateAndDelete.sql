-- ---------------------------------------------------------------------------
-- create database with tables and at leas 1 row to each table. 
-- 10 update operations, 10 delete operations, 5 joins for each kind,
-- 5 GROUP BY, 5 HAVINGS. Create github repository'
-- ---------------------------------------------------------------------------

use mydb;

select * from  `player`; 

-- update

UPDATE `match`
set result = "2-0"
where id =1;

UPDATE `match`
set q_goals = 3
where id =1;

UPDATE captain
SET `name` = "Facundo"
where id_captain = 1;

UPDATE stadium
set id = 2
where id = 3;

UPDATE country
set idcountry = 2
where idCountry = 3;

UPDATE player
set id_player = 2, name = Lucas, goals = 5
where id_player = 3;

UPDATE city
set name = "Carlos Paz"
where idCity = 3;

UPDATE captain
set id_captain = 2
where id_captain = 3;

select * from stadium;

-- delete

DELETE from captain where id_captain = 3;

DELETE from player where id_player = 3;

DELETE from country where idCountry = 2;

DELETE from player where id_player > 14;

DELETE from player where name = "Martin";

DELETE from player where goals > 3;

DELETE from city where name = "Carlos paz";






