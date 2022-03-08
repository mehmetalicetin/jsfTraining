package com.cetin.education.spring.primefaces.masterjsf.chapterseven;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-02
 */
@Named
@ViewScoped
@Data
public class AjaxBean {
    private String name;
    private String surname;
    private String playerName;
    private String playerLastName;
    private String playerName1;
    private String playerLastName1;

    private String request;
    private static final Logger logger = Logger.getLogger(AjaxBean.class.getName());
    private int request_number = 1;

    public int getRequest_number() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        logger.log(Level.INFO, "Is postback (getRequest_number method): {0}", facesContext.isPostback());
        return request_number;
    }
    public void setRequest_number(int request_number) {
        this.request_number = request_number;
    }
    public void requestAction(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        logger.log(Level.INFO, "Is postback (requestAction method): {0}", facesContext.isPostback());
        request_number ++;
    }



    public void upperCaseNameAndSurname(){
        this.name = this.name.toUpperCase();
        this.surname = this.surname.toUpperCase();
    }
    public void cancelNameAndSurname(){
        name ="";
        surname="";
    }
    public void cancelName(){
        name ="";
    }
    public void upperCaseName(){
        this.name = this.name.toUpperCase();
        this.request = this.name.toLowerCase();
    }

    public void ajaxAction() {
        this.name = this.name.toUpperCase();
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        logger.log(Level.INFO, "Surname: {0}", params.get("surnameInputId"));
    }

    public void ajaxMultipleFormAction(){
        this.playerName = this.playerLastName.toUpperCase();
        this.playerLastName = this.playerLastName.toUpperCase();
    }

    public void ajaxMultipleFormAction1(){
        this.playerName1 = this.playerLastName1.toUpperCase();
        this.playerLastName1 = this.playerLastName1.toUpperCase();
    }
}
