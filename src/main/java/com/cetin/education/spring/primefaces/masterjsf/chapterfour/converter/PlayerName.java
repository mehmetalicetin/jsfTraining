package com.cetin.education.spring.primefaces.masterjsf.chapterfour.converter;

import lombok.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-06
 */

@Named(value = "playerName")
@RequestScoped
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerName{
    private String value;
}
