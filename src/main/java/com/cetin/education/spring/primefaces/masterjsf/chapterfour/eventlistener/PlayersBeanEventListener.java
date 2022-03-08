package com.cetin.education.spring.primefaces.masterjsf.chapterfour.eventlistener;

import lombok.Data;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-11
 */
@Named
@Data
public class PlayersBeanEventListener {
    private String bank;
    private String cbank;
    private String name;

    public void validateAccount(ComponentSystemEvent event){
        UIComponent uis = event.getComponent();

        //obtain bank account
        String bankAccount = null;
        UIInput uiBankAccount = (UIInput) uis.findComponent("bankAccountId");
        Object bankAccountObj = uiBankAccount.getLocalValue();
        if (bankAccountObj != null) {
            bankAccount = String.valueOf(bankAccountObj).trim();
        }
        //obtain bank account confirmation
        String bankAccountC = null;
        UIInput uiBankAccountC = (UIInput) uis.findComponent("confirmBankAccountId");
        Object bankAccountCObj = uiBankAccountC.getLocalValue();
        if (bankAccountCObj != null) {
            bankAccountC = String.valueOf(bankAccountCObj).trim();
        }

        if ((bankAccount != null) && (bankAccountC != null)) {
            if (!bankAccount.equals(bankAccountC)) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("Bank account must match bank account confirmation !");
                facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
                facesContext.addMessage(uiBankAccount.getClientId(), facesMessage);
                facesContext.renderResponse();
            }
        }
    }
}
