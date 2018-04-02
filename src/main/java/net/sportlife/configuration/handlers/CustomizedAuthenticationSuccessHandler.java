package net.sportlife.configuration.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //setting response to OK status
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        boolean admin = false;

        logger.info("At onAuthenticationSuccess() function");

        for(GrantedAuthority auth : authentication.getAuthorities()) {
            if("ROLE_ADMIN".equals(auth.getAuthority())){
                admin = true;
            }
        }

        if(admin) {
            httpServletResponse.sendRedirect("/admin");
        } else {
            httpServletResponse.sendRedirect("/authenticated");
        }


    }
}
