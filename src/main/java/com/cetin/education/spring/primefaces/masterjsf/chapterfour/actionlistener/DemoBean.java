package com.cetin.education.spring.primefaces.masterjsf.chapterfour.actionlistener;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-11
 */
@Named
@RequestScoped
public class DemoBean {
    private String demo = "TEST INJECTION VALUE ...";

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
