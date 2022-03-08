package com.cetin.education.spring.primefaces.masterjsf.chapterfour.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-06
 */
@FacesConverter(value="playerConverter")
public class PlayerConverter implements Converter<PlayerName> {
    @Override
    public PlayerName getAsObject(FacesContext context, UIComponent component, String value) {
        PlayerName playerName = new PlayerName(value.toLowerCase());
        return playerName;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, PlayerName playerName) {
        return "Mr. " + playerName.getValue().toUpperCase();
    }
}