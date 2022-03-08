package com.cetin.education.spring.primefaces.masterjsf.chapterseven;

import com.cetin.education.spring.primefaces.masterjsf.chaptertwo.PlayerValidator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2022-02-03
 */
@Named(value = "nameValidator")
@RequestScoped
public class NameValidator implements Validator {
    private static final Logger logger = Logger.getLogger(PlayerValidator.class.getName());

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(String.valueOf(value).contains("@") || String.valueOf(value) == "" || Objects.isNull(value)){
            FacesMessage facesMessage = new FacesMessage("UnValid Name");
            throw new ValidatorException(facesMessage);
        }
    }
}
