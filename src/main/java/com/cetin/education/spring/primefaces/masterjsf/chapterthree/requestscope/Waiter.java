package com.cetin.education.spring.primefaces.masterjsf.chapterthree.requestscope;

import lombok.Data;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-04
 */
/*
* The Waiter session bean receives a request from the test class via the orderSoup() method.
* A Soup insance will be created in this method and will be shared throughout the request with the Chef bean.
* The method passes the request to the Chef bean. It then returns the name of the soup to the test class.
* */
@Stateless
@Data
public class Waiter {
    @Inject
    private Soup soup;

    @EJB
    private Chef chef;

    public String orderSoup(String name){
        soup.setName(name);
        return chef.prepareSoup().getName();
    }
}
