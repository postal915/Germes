package org.germes.presentation.admin.security;

import com.github.postal915.germes.app.service.UserService;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

/**
 * Initializes authentication realm that delegates processing to CDIRealm
 */
@WebListener
public class CdiEnvironmentLoaderListener extends EnvironmentLoaderListener {

    @Inject
    private UserService userService;

    @Override
    protected WebEnvironment createEnvironment(ServletContext context) {
        WebEnvironment environment = super.createEnvironment(context);

        RealmSecurityManager rsm = (RealmSecurityManager) environment.getSecurityManager();

        rsm.setRealm(new CDIRealm(userService));

        return environment;
    }
}
