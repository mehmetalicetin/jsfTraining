package com.cetin.education.spring.primefaces.masterjsf.chapterfour.validator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-06
 */
@Named(value = "emailValidatorByCDI")
@RequestScoped
public class EmailValidatorByCDI implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(!String.valueOf(value).contains("@")){
            FacesMessage facesMessage = new FacesMessage("UnValid Email");
            throw new ValidatorException(facesMessage);
        }
    }
}
