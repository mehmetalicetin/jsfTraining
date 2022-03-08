package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-03
 */
@Named
@SessionScoped
@Data
public class PlayersBeanSessionScopeMap implements Serializable {
    private String playerName;
    private String playerSurname;
}
