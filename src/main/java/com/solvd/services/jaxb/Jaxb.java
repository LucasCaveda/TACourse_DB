package com.solvd.services.jaxb;

import com.solvd.binary.Player;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class Jaxb{

    public static Player unmarshall(File file){

        try {
            JAXBContext jaxbContext =JAXBContext.newInstance(Player.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Player player = (Player) unmarshaller.unmarshal(file);
            return player;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void marshall(Player player, File file){

        try {
            JAXBContext jaxbContext =JAXBContext.newInstance(Player.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(player, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
