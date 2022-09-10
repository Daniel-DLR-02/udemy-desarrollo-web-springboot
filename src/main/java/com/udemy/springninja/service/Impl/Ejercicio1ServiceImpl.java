package com.udemy.springninja.service.Impl;

import com.udemy.springninja.service.Ejercicio1Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("ejercicio1Service")
public class Ejercicio1ServiceImpl implements Ejercicio1Service {

    private final static Log LOG = LogFactory.getLog(Ejercicio1ServiceImpl.class);

    @Override
    public void showLog() {
        LOG.info("Log de información ejercicio1");
    }
}
