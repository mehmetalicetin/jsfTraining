package com.cetin.education.spring.primefaces.masterjsf.chapterfour.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-07
 */
@FacesConverter("UrlConverter")
public class UrlConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       UrlData urlData = new UrlData(value);
        return urlData;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
