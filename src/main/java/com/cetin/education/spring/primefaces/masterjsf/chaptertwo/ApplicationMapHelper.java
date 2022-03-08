package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import javax.faces.context.FacesContext;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-03
 */
public class ApplicationMapHelper {
    public static Object getValueFromApplicationMap(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }
    public static void setValueInApplicationMap(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
    }
}
