package com.cifaz.tools.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanInfo implements BeanPostProcessor {
    private Logger logger = LoggerFactory.getLogger(SpringBeanInfo.class);
    @Value("${spring.bean.printbean:false}")
    private boolean isPringBean;

    @Override
    public Object postProcessBeforeInitialization(Object object, String string) throws BeansException {
        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String string) throws BeansException {
        if (isPringBean) {
            logger.info(" == spring bean name : "  + string);
        }
        return object;
    }
}
