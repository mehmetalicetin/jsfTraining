package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-03
 */
@Named
@RequestScoped
public class PlayersBeanSet {
    public void playerSetAction() {
        ApplicationMapHelper.setValueInApplicationMap("PlayersBeanSet.name", "Rafael");
        ApplicationMapHelper.setValueInApplicationMap("PlayersBeanSet.surname", "Nadal");
    }
}
