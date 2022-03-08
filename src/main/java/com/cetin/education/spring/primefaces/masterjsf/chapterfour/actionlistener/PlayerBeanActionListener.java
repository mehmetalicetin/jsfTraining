package com.cetin.education.spring.primefaces.masterjsf.chapterfour.actionlistener;

import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-11
 */
@Named
public class PlayerBeanActionListener {
    private static final Logger logger = Logger.getLogger(PlayerListener.class.getName());

    public void playerListener(ActionEvent e) {
        logger.log(Level.INFO, "playerListener method called ...");
    }

    public void playerDone(){
        logger.log(Level.INFO, "playerDone method called ...");
    }
}
