package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import lombok.Data;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-03
 */
@Named
@RequestScoped
@Data
public class ProfileBeanRequestScopeMap {
    private static final Logger logger = Logger.getLogger(PlayersBeanSessionScopeMap.class.getName());
    PlayersBeanSessionScopeMap playersBeanSessionScope;

    public void evaluateExpressionGet(){
        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elcontext = context.getELContext();
        playersBeanSessionScope = (PlayersBeanSessionScopeMap)elcontext.getELResolver().getValue(elcontext, null,"playersBeanSessionScope");
        if (playersBeanSessionScope != null) {
            //call the PlayersBeanRequestScope method
        } else {
            logger.info("SESSION BEAN NOT FOUND!");
        }
    }

    public void createValueExpression(){
        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elcontext = context.getELContext();
        playersBeanSessionScope = (PlayersBeanSessionScopeMap) createValueExpression("#{playersBeanSessionScope}", PlayersBeanSessionScopeMap.class).getValue(elcontext);
        if (playersBeanSessionScope != null) {
                //call the PlayersBeanRequestScope method
        } else {
            logger.info("SESSION BEAN NOT FOUND!");
        }
    }

    private ValueExpression createValueExpression(String exp, Class<?> cls) {
        FacesContext context = FacesContext.getCurrentInstance();
        ELContext elcontext = context.getELContext();
        return context.getApplication().getExpressionFactory().createValueExpression(elcontext, exp, cls);
    }

    public void process(){
        logger.log(Level.INFO,"Player Name : {0} ",playersBeanSessionScope.getPlayerName());
        logger.log(Level.INFO,"Player Surname : {0}",playersBeanSessionScope.getPlayerSurname());
    }
}
