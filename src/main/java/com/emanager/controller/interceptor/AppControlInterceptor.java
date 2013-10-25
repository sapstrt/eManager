package com.emanager.controller.interceptor;

import com.emanager.service.GoogleTokenValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: vvarm1
 * Date: 10/22/13
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppControlInterceptor implements HandlerInterceptor {
    @Autowired
    GoogleTokenValidator validator;
    final static Logger LOGGER = LoggerFactory.getLogger(AppControlInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        LOGGER.debug("Pre method of interceptor");
        String idToken=httpServletRequest.getHeader("idToken");
        String user=null;
        LOGGER.debug("The value of ID Token is "+idToken);
        if (idToken==null){
            httpServletResponse.setStatus(400);
            return false;
        }

        else if ((user=validator.validateIdTokenAndGetEmailId(idToken))!=null){
            httpServletRequest.getSession().setAttribute("user",user);
            return true;
        }
        else{
            httpServletResponse.setStatus(400);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
