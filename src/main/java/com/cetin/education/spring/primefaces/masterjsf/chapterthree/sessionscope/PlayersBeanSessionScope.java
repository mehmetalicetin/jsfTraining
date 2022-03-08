package com.cetin.education.spring.primefaces.masterjsf.chapterthree.sessionscope;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-04
 */
@Named
@SessionScoped
@Data
public class PlayersBeanSessionScope implements Serializable {
    final String[] players_list = {"Nadal, Rafael (ESP)","Djokovic, Novak (SRB)", "Ferrer, David (ESP)", "Murray, Andy (GBR)",
            "Del Potro, Juan Martin (ARG)"};
    private ArrayList players = new ArrayList();
    private String player;

    public void newPlayer() {
        int nr = new Random().nextInt(4);
        player = players_list[nr];
        players.add(player);
    }
}
