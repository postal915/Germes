package com.github.postal915.germes.app.rest.service.config;

import com.github.postal915.germes.app.config.ComponentFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * REST web-service configuration for Jersey
 */
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super(ComponentFeature.class);
        packages("com.github.postal915.germes.app.rest");
    }
}
