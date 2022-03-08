package com.cetin.education.spring.primefaces.masterjsf.chapterone;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-28
 */
@Named("chapterOne")
@RequestScoped
public class ChapterOne {
    private Map<String, String> matchfacts = new HashMap<>();

    private PLAY play;

    private String facebookAddress;

    private boolean show_prize = false;

    private double prize = 100.99;
    private boolean show_racquet;

    private String[] titles_2013 = {"Sao Paulo", "Acapulco", "ATP World Tour Masters 1000 Indian Wells", "Barcelona"};


    List<Integer> costBeforeVAT = Arrays.asList(34, 2200, 1350, 430, 57, 10000, 23, 15222, 1);


    public String[] getTitles_2013() {
        return titles_2013;
    }

    @PostConstruct
    public void init(){
        matchfacts.put("Aces", "12");
        matchfacts.put("Double Faults", "2");
        matchfacts.put("1st Serve", "70%");
        play = PLAY.Left;
    }

    public void showPrizeMoney(){
        this.show_prize = true;
    }

    public void hidePrizeMoney(){
        this.show_prize = false;
    }

    public void showHideRacquetPicture(ValueChangeEvent e){
        if(e.getNewValue() == Boolean.TRUE){
            this.show_racquet=true;
        } else {
            this.show_racquet=false;
        }
    }

    public Map<String, String> getMatchfacts() {
        return matchfacts;
    }

    public void vamosRafa_1(){
        System.out.println("Vamos Rafa!");
    }

    public String vamosRafa_2(){
        return "Vamos Rafa!";
    }

    public void vamosRafa_3(String text){
        System.out.println(text);
    }

    public PLAY getPlay() {
        return play;
    }

    public void setPlay(PLAY play) {
        this.play = play;
    }

    public String getFacebookAddress() {
        return facebookAddress;
    }

    public void setFacebookAddress(String facebookAddress) {
        this.facebookAddress = facebookAddress;
    }

    public boolean isShow_prize() {
        return show_prize;
    }

    public double getPrize() {
        return prize;
    }

    public boolean isShow_racquet() {
        return show_racquet;
    }

    public List<Integer> getCostBeforeVAT() {
        return costBeforeVAT;
    }
}
