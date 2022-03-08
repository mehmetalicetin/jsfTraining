package com.cetin.education.spring.primefaces.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-31
 */
@Component
public class EmbeddedTomcatConfig implements WebServerFactoryCustomizer {
    @Override
    public void customize(WebServerFactory factory) {
        ((TomcatServletWebServerFactory)factory).addContextCustomizers(new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                context.setCookieProcessor(new LegacyCookieProcessor());
            }
        });
    }
}
