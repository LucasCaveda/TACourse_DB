-- group by/having

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




