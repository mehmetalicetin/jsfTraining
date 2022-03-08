package com.cetin.education.spring.primefaces.masterjsf.chapterfour.validator;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-06
 */
@Named
@RequestScoped
@Data
public class Email {
    private String mail;
}
