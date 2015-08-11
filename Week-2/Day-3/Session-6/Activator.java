/* W2-D3-S6 Activator.java */



package com.adobe.training;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Activator.class);
    
    public void start(BundleContext context) throws Exception {
        LOGGER.info("bundle started");
    }

    public void stop(BundleContext context) throws Exception {
        LOGGER.info("bundle stopped");
    }

}


/* W2-D3-S6 Activator.java ends */