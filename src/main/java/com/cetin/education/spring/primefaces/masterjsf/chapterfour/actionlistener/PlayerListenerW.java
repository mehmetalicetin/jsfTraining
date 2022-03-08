package com.cetin.education.spring.primefaces.masterjsf.chapterfour.actionlistener;

import javax.faces.event.ActionListener;
import javax.faces.event.ActionListenerWrapper;
import javax.inject.Named;

/**
 * @Author mehmetali.cetin
 * @Date 2022-01-11
 */
public class PlayerListenerW extends ActionListenerWrapper {
    PlayerListener playerListener = new PlayerListener();
    @Override
    public ActionListener getWrapped() {
        return playerListener;
    }
}
