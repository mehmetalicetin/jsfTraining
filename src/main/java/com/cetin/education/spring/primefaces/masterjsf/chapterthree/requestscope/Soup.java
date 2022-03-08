package com.cetin.education.spring.primefaces.masterjsf.chapterthree.requestscope;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-04
 */
/*
* The Soup class is an injectable POJO, defined as @RequestScoped.
* This means that an instance will be created only once for every request and will be shared by all the beans injecting it.
* Singleton
* */
@RequestScoped
@Data
public class Soup {

    private String name = "Soup of the day";

    @PostConstruct
    public void afterCreate() {
        System.out.println("Soup created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
