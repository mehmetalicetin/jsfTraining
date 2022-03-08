package com.cetin.education.spring.primefaces.masterjsf.chapterseven;

import lombok.Data;

import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-09
 */
@Data
@Named
public class RegistrationBean {
    private String playerName = "";
    private String playerSurname = "";

    public void credentialsUpperCase(){
        this.playerName = this.playerName.toUpperCase();
        this.playerSurname = this.playerSurname.toUpperCase();
    }

    public String getReturnValue(){
        return "/done";
    }

    public String registrationAction(){
        return "confirm";
    }
}
