package com.cetin.education.spring.primefaces;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-05
 */

@Named
@SessionScoped
public class DashboardView implements Serializable {
    private Logger logger = Logger.getLogger(DashboardView.class.getName());
    private DashboardModel model;

    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();

        column1.addWidget("hello");

        column1.addWidget("sports");
        column1.addWidget("finance");

        column2.addWidget("lifestyle");
        column2.addWidget("weather");

        column3.addWidget("politics");

        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);
    }

    public String player1Success() {
        logger.log(Level.INFO, "playerDone method called ...");
        return "success";
//     faces_config.xml   Wildcard ("*") is supported to specify a navigation rule that applies
//        to all pages. It can be useful for a logout page.
    }

    public String playerDone() {
        logger.log(Level.INFO, "playerDone method called ...");
        return "done";
    }

    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex()
                + ", Sender index: " + event.getSenderColumnIndex());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public DashboardModel getModel() {
        return model;
    }
}
