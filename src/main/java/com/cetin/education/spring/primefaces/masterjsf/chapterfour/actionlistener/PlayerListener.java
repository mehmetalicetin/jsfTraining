package com.cetin.education.spring.primefaces.masterjsf.chapterfour.actionlistener;

import com.cetin.education.spring.primefaces.LoginBean;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-11
 */
public class PlayerListener implements ActionListener {
    private static final Logger logger = Logger.getLogger(PlayerListener.class.getName());

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        logger.log(Level.INFO, "Player listener class called ...");
    }
}
