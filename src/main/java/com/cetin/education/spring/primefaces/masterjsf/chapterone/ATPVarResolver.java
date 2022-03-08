package com.cetin.education.spring.primefaces.masterjsf.chapterone;

import com.sun.faces.util.MessageUtils;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;
import java.beans.FeatureDescriptor;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-29
 */
public class ATPVarResolver extends ELResolver {

    private static final String EL_CONTEXT_NAME = "elContext";
    private static final Logger logger = Logger.getLogger(ATPVarResolver.class.getName());
    private static final String PLAYERS = "atp";
    private final Class<?> CONTENT = List.class;

    @Override
    public Object getValue(ELContext elContext, Object base, Object property) {
        logger.log(Level.INFO,"Get value property : {0}",property);
        if(base == null && property.equals(PLAYERS)){
            logger.log(Level.INFO,"Found request : {0}",base);
            elContext.setPropertyResolved(true);
           return new ATPSinglesRankings();
        }
        return null;
    }

    @Override
    public Class<?> getType(ELContext elContext, Object base, Object property) {
        if(base != null)
            return null;
        if(property == null){
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID,"property");
            throw new PropertyNotFoundException(message);
        }
        if(base == null && property.equals(PLAYERS)){
            elContext.setPropertyResolved(true);
            return CONTENT;
        }
        return null;
    }

    @Override
    public void setValue(ELContext elContext, Object o, Object base, Object property) {
        if (base != null) {
            return;
        }
        elContext.setPropertyResolved(false);
        if (property == null) {
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "property");
            throw new PropertyNotFoundException(message);
        }
        if (PLAYERS.equals(property)) {
            throw new PropertyNotWritableException((String)
                    property);
        }
    }

    @Override
    public boolean isReadOnly(ELContext elContext, Object base, Object property) {
        return true;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext elContext, Object o) {
        return null;
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext elContext, Object base) {
        if (base != null) {
            return null;
        }
        return String.class;
    }
}
