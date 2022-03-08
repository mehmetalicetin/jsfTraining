package com.cetin.education.spring.primefaces.masterjsf.chaptertwo.flashscope;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-31
 */

@Named("playersBean2")
@RequestScoped
@Data
public class PlayersBean2 {
    /*
    * The new JSF Flash scope is a very handy tool when you need to pass parameters
      between user views without the need to store them in the session.
    * */

    private static final Logger logger = Logger.getLogger(PlayersBean2.class.getName());
    private String playerName;
    private String playerSurname;

    public String addValuesToFlashAction() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("playerName", playerName);
        flash.put("playerSurname", playerSurname);
        return "terms?faces-redirect=true";
    }

    public void pullValuesFromFlashAction(ComponentSystemEvent e) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        playerName = (String) flash.get("playerName");
        playerSurname = (String) flash.get("playerSurname");
    }

    public String termsAcceptedAction(){
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        pullValuesFromFlashAction(null);


        //do something with firstName, lastName
        logger.log(Level.INFO, "First name: {0}", playerName);
        logger.log(Level.INFO, "Last name: {0}", playerSurname);

        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Terms accepted and player registered"));
        return "done?faces-redirect=true";
    }

    public String termsRejectedAction() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.setKeepMessages(true);
        pullValuesFromFlashAction(null);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Terms rejected! Player not registered!"));
        return "index?faces-redirect=true";
    }
}
