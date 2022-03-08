package com.cetin.education.spring.primefaces.masterjsf.chapterfour.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-06
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(!String.valueOf(value).contains("@")){
            FacesMessage facesMessage = new FacesMessage("UnValid Email");
            throw new ValidatorException(facesMessage);
        }
    }
}
