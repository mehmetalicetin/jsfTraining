package com.cetin.education.spring.primefaces.masterjsf.chapterthree.requestscope;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Random;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-04
 */
@Named
@RequestScoped //this is the default scope
@Data
public class PlayersBeanRequestScope {
    final String[] players_list = {"Nadal, Rafael (ESP)","Djokovic, Novak (SRB)", "Ferrer, David (ESP)", "Murray, Andy (GBR)",
            "Del Potro, Juan Martin (ARG)"};
    private ArrayList players = new ArrayList();
    private String player;

    public void newPlayer() {
        int nr = new Random().nextInt(4);
        player = players_list[nr];
        players.add(player);
    }

    /*The request scope doesn't lose the object's state while forwarding,
        because the source page and the destination page (the forwarded page)
        are part of the same request-response cycle. This is not true in the case
        of redirect actions.
     * */

    /*
    * • If the same view or forward is used, then the data is available for display on page 2
      • If redirect is used, then data will be lost and not available for display on page 2
    * */
}
