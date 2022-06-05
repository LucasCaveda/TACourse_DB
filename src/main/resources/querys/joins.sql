-- joins

SELECT * from player left join football_team
on football_team.id=player.football_team_id;

SELECT * from football_team left join city
on football_team.city_id=city.id

SELECT player.football_team_id, football_team.id
from player
inner join football_team on football_team.id = player.football_team_id;

SELECT `match.championship_id`, championship.id
from `match`
inner join championship on championship.id = `match.championship_id`;

SELECT * FROM player.id_player RIGHT JOIN player ON player.id=1;

SELECT * FROM `match` RIGHT JOIN football_team ON match.football_team1_id >1;

