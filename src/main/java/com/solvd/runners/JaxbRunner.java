package com.solvd.runners;

import com.solvd.binary.Player;
import com.solvd.services.jaxb.Jaxb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class JaxbRunner {
    private final static Logger LOGGER = LogManager.getLogger(JaxbRunner.class);


    public static void main(String[] args) {
        Player player = new Player(4, "Julian", "Gonzalez", null, 5, 0, 0, 1);
        Player playerUnmarshalled = new Player();

        File file = new File("src/main/resources/Player.xml");

        Jaxb.marshall(player,file);
        LOGGER.info("Marshall executed");

        playerUnmarshalled = Jaxb.unmarshall(file);
        LOGGER.info("Unmarshall executed, objects created: "+ playerUnmarshalled);
    }
}
