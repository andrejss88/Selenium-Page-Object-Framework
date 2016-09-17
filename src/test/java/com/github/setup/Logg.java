package com.github.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Andre on 9/17/2016.
 */
public class Logg {

    private static Logger LOG = LoggerFactory.getLogger(Logg.class);

    private Logg() {
    }

    public static Logger getLog() {
        return LOG;
    }
}
