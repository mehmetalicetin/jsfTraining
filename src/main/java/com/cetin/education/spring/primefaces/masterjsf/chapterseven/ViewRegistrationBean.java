package com.cetin.education.spring.primefaces.masterjsf.chapterseven;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-09
 */
@Named
@ViewScoped
@Data
public class ViewRegistrationBean implements Serializable {
    @Inject
    RegistrationBean registrationBean;
    private String playerNameView = "nothing";
    private String playerSurnameView = "nothing";
    private static final Map<Integer, String> myMap = new HashMap<>();
    static {
        myMap.put(1, "Nadal Rafael");
        myMap.put(2, "Federer Roger");
    }

    @PostConstruct
    public void init() {
        Random r = new Random();
        int key = 1+r.nextInt(2);
        String player = myMap.get(key);
        String[] fullname = player.split(" ");
        playerNameView = fullname[0];
        playerSurnameView = fullname[1];
        playerNameView = playerNameView.toUpperCase();
        playerSurnameView = playerSurnameView.toUpperCase();
    }

    public void generateCredentials() {
        registrationBean.setPlayerName(playerNameView);
        registrationBean.setPlayerSurname(playerSurnameView);
    }
}
