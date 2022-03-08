package com.cetin.education.spring.primefaces.masterjsf.chaptertwo;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-30
 */
@FacesValidator(value = "playerValidator")
public class PlayerValidator implements Validator {
    private static final Logger logger = Logger.getLogger(PlayerValidator.class.getName());

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        final Map<String, String> requestParameterMap = context.getExternalContext().getRequestParameterMap();
        String playerName = requestParameterMap.get("playerNameParam");
        String playerSurname = requestParameterMap.get("playerSurnameParam");
        logger.log(Level.INFO,"Player Name-Player Surname: {0}",playerName+"-"+playerSurname);

        if(playerName == null || playerSurname == null || playerName.isEmpty() || playerSurname.isEmpty()){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Empty fields", "Player Name and Player Surname cannot be empty");
            throw new ValidatorException(msg);
        }
    }
}
