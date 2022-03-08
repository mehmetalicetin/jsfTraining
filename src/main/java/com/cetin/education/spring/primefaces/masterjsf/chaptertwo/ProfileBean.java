package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import lombok.Data;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-03
 */
@Named(value = "profileBean")
@ViewScoped
@Data
public class ProfileBean {

    /*
    * Now, let's suppose that you want to have access to this bean's properties
           from another view scoped bean, named ProfileBean
    * */

    private static final Logger logger = Logger.getLogger(ProfileBean.class.getName());


    @Inject
    private PlayersBean playersBean;

    private String greetings;

    @PostConstruct
    public void init(){
        greetings = "Hello, " + playersBean.getPlayerName() + " " +playersBean.getPlayerSurname() + " !";
    }

    public void greetingsAction(){
        logger.info(greetings);
    }

}
