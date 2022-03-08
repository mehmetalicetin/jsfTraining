package com.cetin.education.spring.primefaces.ajaxUpdate;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Named("myBean")
@RequestScoped
public class MyBean {
    private String welcomeMessage = "Populated by spring created bean";

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    private String city;
    private Map<String, String> cities = new HashMap<>();

    private String value;

    private Date date;

    @PostConstruct
    public void init(){
        //cities
        cities = new HashMap<>();
        cities.put("New York", "New York");
        cities.put("London", "London");
        cities.put("Paris", "Paris");
        cities.put("Barcelona", "Barcelona");
        cities.put("Istanbul", "Istanbul");
        cities.put("Berlin", "Berlin");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
