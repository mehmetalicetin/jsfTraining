package com.cetin.education.spring.primefaces.masterjsf.chaptersix;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-26
 */
@Data
public class Players {
    private int key;
    private String player;
    private byte age;
    private String birthplace;
    private String residence;
    private short height;
    private byte weight;
    private String coach;
    private Date born;
    private int ranking;

    @Transient // it is matter if the POJO is an entity.
    private boolean edited;

    public Players(int key, String player, byte age, String birthplace, String residence, short height, byte weight, String coach, Date born, int ranking) {
        this.key = key;
        this.player = player;
        this.age = age;
        this.birthplace = birthplace;
        this.residence = residence;
        this.height = height;
        this.weight = weight;
        this.coach = coach;
        this.born = born;
        this.ranking = ranking;
    }
}
