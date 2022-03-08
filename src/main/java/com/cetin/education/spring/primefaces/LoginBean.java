package com.cetin.education.spring.primefaces;

import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-07
 */
@Named(value = "loginBean")
@SessionScoped
@Data
public class LoginBean implements Serializable {
    private static final Logger logger = Logger.getLogger(LoginBean.class.getName());
    private boolean render;

    public String playerLogin() {
        Random random = new Random();
        int r = random.nextInt(10);
        render = r > 5;
        return "done";
    }

    public String navigateHelper() {
        if (!render) {
            return "/failed.xhtml";
        } else {
            return "/success.xhtml";
        }
    }
}
