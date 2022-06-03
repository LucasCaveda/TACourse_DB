use mydb;

insert into captain (football_team_id)
values(1);

insert into championship(`name`, football_league_id)
values("Copa Libertadores", 1);

insert into championship(`name`, football_league_id)
values("Copa Argentina", 1);

insert into championship(`name`, football_league_id)
values("Copa Sudamericana", 1);

insert into city (`name`, country_id)
values("Mar del Plata", 1);

insert into city (`name`, country_id)
values("Buenos Aires", 1);

SELECT `country`.`idCountry`,
    `country`.`name`
FROM `mydb`.`country`;


insert into country (`name`)
values("Argentina");

insert into country (`name`)
values("Brasil");

truncate table fan;

insert into fan(`name`,`lastname`, ticket_id)
values("Juan", "Espinoza", 1);

insert into football_league (`name`, category)
values("superliga", "A");

insert into football_team (`name`, technical_manager_id, stadium_id, president_id, city_id)
values("Aldosivi", 1, 1, 1,1);

insert into `match`(q_goals,result,`date`,championship_id,stadium_id,football_team_id,football_team_technical_manager_id)
values(0,0,'2022-05-17',1,1,1,1);

insert into `owner`(`name`,lastname,football_team_id)
values("Juan","Gonzalez",1);

insert into  partners(brand_name,football_team_id)
values("plusmar",1);

insert into player(`name`,lastname,birthday,shirt_number,banns,goals,football_team_id)
values("Martin","Cauteruccio",'1987-04-14',77,0,0,1);

insert into player(`name`,lastname,birthday,shirt_number,banns,goals,football_team_id)
values("Santiago","Silva",'1980-12-09',9,0,2,1);

insert into player(`name`,lastname,birthday,shirt_number,banns,goals,football_team_id)
values("Edwin","Mosquera",'2001-06-27',70,0,0,1);

insert into player(`name`,lastname,birthday,shirt_number,banns,goals,football_team_id)
values("Nicolas","Valentini",'2001-04-6',13,0,0,1);

insert into president(`name`,lastname)
values("Jose","Moscuzza");

insert into referee(`name`,lastname,birthday,match_id)
values("Fernando","Rapallini",'1978-04-28',1);

insert into stadium(`name`,city_id)
values("Jose Maria Minella",1);

insert into technical_manager(`name`,lastname,birthday)
values("Martin", "Palermo",'1973-11-7');

insert into ticket(`date`,ubication,stadium_id)
values('2022-05-17',233,1);