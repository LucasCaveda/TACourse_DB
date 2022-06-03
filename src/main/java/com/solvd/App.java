package com.solvd;

import com.solvd.binary.Player;
import com.solvd.dao.util.ConnectionPool;
import com.solvd.services.impl.PlayerImpl;
import com.solvd.services.interfaces.PlayerService;
import com.solvd.services.mybatys.MBPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class App {

    private final static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        try (Connection c = ConnectionPool.getInstance().getConnection()) {
            if (c != null) {
                LOGGER.info("You are inside now");
            } else {
                LOGGER.info("You did not Connect to the server");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Testing different kind of services

        Player player = new Player(9, "Julian", "Gonzalez", null, 5, 0, 0, 1);
        Player player2 = new Player(10, "Juan", "Perez", null, 66, 3, 3, 1);

        PlayerService ps = new PlayerImpl();

        LOGGER.info(ps.getPlayer(1).toString());

        ps.update(9,player2);

        MBPlayer mbps = new MBPlayer();

        LOGGER.info(mbps.getPlayer(3).toString());

        LOGGER.info(mbps.getAllPlayers());

    }
}
