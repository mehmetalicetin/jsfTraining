package com.cetin.education.spring.primefaces.masterjsf.chapterthree.requestscope;

import lombok.Data;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-04
 */

/*
* The Chef class is a simple session bean with an injected Soup field.
* Normally, the soup parameter would be passed as a prepareSoup() argument,
* but for the need of this example it's passed by the request context.
* */
@Stateless
@Data
public class Chef {
    @Inject
    private Soup soup;

    public Soup prepareSoup() {
        return soup;
    }
}