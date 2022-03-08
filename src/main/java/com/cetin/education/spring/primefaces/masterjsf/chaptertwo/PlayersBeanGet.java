package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-03
 */
@Named
@SessionScoped
public class PlayersBeanGet implements Serializable {
    private final static Logger logger = Logger.getLogger(PlayersBeanGet.class.getName());

    public void playerGetAction(){
        String name = String.valueOf(ApplicationMapHelper.getValueFromApplicationMap("PlayersBeanSet.name"));
        String surname = String.valueOf(ApplicationMapHelper.getValueFromApplicationMap("PlayersBeanSet.surname"));
        logger.log(Level.INFO, "Name: {0} Surname: {1}", new Object[]{name, surname});
    }
}
