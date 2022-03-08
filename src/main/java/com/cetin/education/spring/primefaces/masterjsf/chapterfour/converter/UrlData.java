package com.cetin.education.spring.primefaces.masterjsf.chapterfour.converter;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-07
 */
@Data
@Named("userData")
@NoArgsConstructor
public class UrlData {
    private String url;

    public UrlData(String url) {
        this.url = url;
    }
}
