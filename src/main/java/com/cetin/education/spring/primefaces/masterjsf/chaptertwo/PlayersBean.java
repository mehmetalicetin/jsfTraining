package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import lombok.Data;
import org.primefaces.event.FileUploadEvent;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-29
 */
@Named("playersBean")
@RequestScoped
//@Data
//@ManagedBean("playersBean")
public class PlayersBean {

    Logger logger = Logger.getLogger(PlayersBean.class.getName());

    /*
    * @ManagedProperty is usable only with
      beans managed by JSF (@ManagedBean), not with beans managed by CDI (@Named).
    * */

    //@ManagedProperty("#{param.playerNameParam}")
    private String playerName;

    //@ManagedProperty("#{param.playerSurnameParam}")
    private String playerSurname;

    private String playerPassword;

    private Date date;
    private Object dataArryList;

    public PlayersBean() {
        this.playerName = "Rafael";
        this.playerSurname = "Nadal";
    }

    public void sayHello(){
        logger.log(Level.INFO,"Hello I am here in PlayersBean2");
    }

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            if (playerName != null)
                playerName = playerName.toUpperCase();
            if (playerSurname != null)
                playerSurname = playerSurname.toUpperCase();
        }
    }

    public String initViewAction() {
        if (playerName != null)
            playerName = playerName.toUpperCase();
        if (playerSurname != null)
            playerSurname = playerSurname.toUpperCase();
        return "start";

    }

    public String sendDate() {
        String dateAsString = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return "date.xhtml?faces-redirect=true&date=" + dateAsString;
    }

    public String validateData(){
        //validation conditions
        return "index"; //or other page
    }

    public String toUpperCase(){
        playerName=playerName.toUpperCase();
        playerSurname=playerSurname.toUpperCase();
        return "another_page?faces-redirect=true&includeViewParams=true";
    }


    public void getContextParam(){
        final String initParameter = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("number");
        System.out.println("init parameter: "+ initParameter);
    }

    public String parametersAction() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        final Map<String, String> requestParameterMap = facesContext.getExternalContext().getRequestParameterMap();
        playerName = requestParameterMap.get("playerNameParam");
        playerSurname = requestParameterMap.get("playerSurnameParam");
        return "another_page.xhtml";
    }

    public void parametersActionListener(ActionEvent actionEvent){
       playerName = (String) actionEvent.getComponent().getAttributes().get("playerNameAttr");
       playerSurname = (String) actionEvent.getComponent().getAttributes().get("playerSurnameAttr");
       logger.log(Level.INFO,"Name : {0} Surname : {1}",new Object[]{playerName,playerSurname});
    }

    public void parametersActionPropertyActionListener(){
        logger.log(Level.INFO,"Player Name : {0}  Player Surname : {1}",new Object[]{playerName, playerSurname});
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        logger.log(Level.INFO,"Player Name : {0} ",new Object[]{this.playerName});
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
        logger.log(Level.INFO,"Player Surname : {0}",new Object[]{this.playerSurname});
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    public void addCookie() {
        Object name_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("name");
        Object surname_cookie = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap().get("surname");
//set playerName property
        if (name_cookie != null) {
            playerName = (((Cookie) name_cookie).getValue());
        }
//set playerSurname property
        if (surname_cookie != null) {
            playerSurname = (((Cookie) surname_cookie).getValue());
        }

        logger.log(Level.INFO,"Player Name : {0} ",playerName);
        logger.log(Level.INFO,"Player Surname : {0}",playerSurname);

    }

    public void parametersActionHidden() {
        logger.log(Level.INFO,"Player Name: {0}",playerName);
        logger.log(Level.INFO, "Player Surname: {0}",playerSurname);
    }

    public void passwordAction() {
        logger.log(Level.INFO,"Player Password: {0}",playerPassword);
    }

    public void processAction() {
        UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent uiComponentName = uiViewRoot.findComponent("playerFormId:playernameid");
        Object prev = uiComponentName.getAttributes().put("value","RAFAEL");
        UIComponent uiComponentSurname = uiViewRoot.findComponent("playerFormId:playersurnameid");
        Object current = uiComponentSurname.getAttributes().put("value","NADAL");

    }

    public String passingParameters(String playerName, String playerSurname) {
        this.playerName = playerName;
        this.playerSurname = playerSurname;
        return "another_page";
    }

    public Object getDataArryList() {
        return dataArryList;
    }

    public void setDataArryList(Object dataArryList) {
        this.dataArryList = dataArryList;
    }

    private HtmlDataTable table;

    public HtmlDataTable getTable() {
        return table;
    }

    public void setTable(HtmlDataTable table) {
        this.table = table;
    }

    public void tableAction() {
        table.setRows(3);
        logger.log(Level.INFO, "First:{0}", table.getFirst());
        logger.log(Level.INFO, "Row count: {0}", table.getRowCount());
    }
}
