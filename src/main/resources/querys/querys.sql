-- ---------------------------------------------------------------------------
-- create database with tables and at leas 1 row to each table. 
-- 10 update operations, 10 delete operations, 5 joins for each kind,
-- 5 GROUP BY, 5 HAVINGS. Create github repository'
-- ---------------------------------------------------------------------------

use mydb;

select * from  `player`; 

-- update --------------------------------------------------------------------

UPDATE `match`
set result = "2-0"
where id =1;

UPDATE `match`
set q_goals = 3
where id =1;

UPDATE captain
set `name` = "Lucas"
where `name` = "Facundo";

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

UPDATE player
set goals = 4
where goals = 2;

UPDATE city
set name = "Carlos Paz"
where idCity = 3;

UPDATE captain
set id_captain = 2
where id_captain = 3;

select * from stadium;

-- delete --------------------------------------------------------------------

DELETE from captain where id_captain = 3;

DELETE from player where id_player = 3;

DELETE from country where idCountry = 2;

DELETE from country where idCountry = 1;

DELETE from player where id_player > 14;

DELETE from player where name = "Martin";

DELETE from player where goals > 3;

DELETE from player where banns > 1;

DELETE from city where name = "Carlos paz";

DELETE from city where name = "Mar del Plata";

-- group by/having -----------------------------------------------------------

select lastname, match_id
from referee
group by name
having match_id=1;

select name, country_id
from city
group by name
having country_id=1;

select (id), name
from football_team
group by name
having id > 5;

select player.name
from player
group by name
having player.shirt_number>10;

SELECT player.id_player, player.name
FROM player
GROUP BY player.id_player, player.name
HAVING player.id_player>2;

-- joins ---------------------------------------------------------------------

-- LeftJoin

SELECT * from player left join football_team
on football_team.id=player.football_team_id;

SELECT * from football_team left join city
on football_team.city_id=city.id;

SELECT * from city left join country
on city.country_id=city_id;

SELECT * from player left football_league
on id_player=2;

SELECT * from championship left join football_league
on championship.football_league_id=football_league.id;

-- InnerJoin

SELECT player.football_team_id, football_team.id from player
inner join football_team on football_team.id = player.football_team_id;

SELECT `match.championship_id`, championship.id from `match`
inner join championship on championship.id = `match.championship_id`;

SELECT * from match
inner join football_team ON match.football_team1_id >1;

SELECT * from match
inner join football_team on id_technical_manager = 1;

SELECT * from captain
inner join football_team on football_team_id >1;

-- RightJoin

SELECT * from player.id_player
RIGHT JOIN player ON player.id=1;

SELECT * from `match`
RIGHT JOIN football_team ON match.football_team1_id >1;

SELECT * from technical_manager
right join football_team on id_technical_manager = 1;

SELECT * from technical_manager
right join football_team on football_team_id = 1;

SELECT * from football_team
right join city on football_team.city_id=city.id;








