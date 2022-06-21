package com.solvd;

import com.solvd.binary.Player;
import com.solvd.services.interfaces.PlayerService;
import com.solvd.services.impl.PlayerImpl;
import com.solvd.services.jaxb.Jaxb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static com.solvd.services.dom.DomParser.playersXML;
import static com.solvd.services.json.Json.jsonService;


public class App {

    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        PlayerService ps = new PlayerImpl();

        // Creating some players to play with

        Player player = new Player(9, "Julian", "Gonzalez", null, 5, 0, 0, 1);
        Player player2 = new Player(10L, "Juan", "Perez", null, 66, 1, 1, 1);

        LOGGER.info(ps.getPlayer(1).toString());

        // Playing with some kind of services

        ps.create(player2);
        //LOGGER.info(ps.getPlayer(10L).toString());
        ps.delete(10L);
        LOGGER.info(ps.getAllPlayers());
        ps.update(9L,player2);
        LOGGER.info("\n------------------------------------------------------------------------------------------------------\n");
        LOGGER.info("The player "+ ps.getPlayer(9).getName() +" "+ ps.getPlayer(9).getLastname() + " has " + ps.getPlayer(9).getBanns() +" banns and " + ps.getPlayer(9).getGoals()+ " goals this season ");
        LOGGER.info("\n------------------------------------------------------------------------------------------------------\n");
        LOGGER.info("Updating data");
        player.setGoals(3);
        player.setBanns(1);
        ps.update(9L,player);
        LOGGER.info("The player "+ ps.getPlayer(9).getName() +" "+ ps.getPlayer(9).getLastname() + " has " + ps.getPlayer(9).getBanns() +" banns and " + ps.getPlayer(9).getGoals()+ " goals this season ");
        LOGGER.info("\n------------------------------------------------------------------------------------------------------\n");

        // json

        File file= new File("src/main/resources/json/Player.json");

        jsonService(file);

        // Jaxb

        Player playerUnmarshalled = new Player();

        File file2 = new File("src/main/resources/Player.xml");

        Jaxb.marshall(player,file2);
        LOGGER.info("Marshall executed");

        playerUnmarshalled = Jaxb.unmarshall(file2);
        LOGGER.info("Unmarshall executed, objects created: "+ playerUnmarshalled);


        playersXML();
    }
}
