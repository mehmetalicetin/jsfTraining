package com.cetin.education.spring.primefaces.masterjsf.chapterfour.actionlistener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-11
 */
public class ApplicationPlayerListener implements ActionListener {
    private static final Logger logger = Logger.getLogger(ApplicationPlayerListener.class.getName());
    private ActionListener actionListener;


    @Inject
    private DemoBean demoBean;

    public ApplicationPlayerListener() {
    }

    public ApplicationPlayerListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        logger.log(Level.INFO, "ApplicationPlayerListener class called...");
        actionListener.processAction(event);

    }
}
