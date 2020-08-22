package com.bh.bhlibrary.Interceptor;

import com.bh.bhlibrary.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;

/**
 * @author 17331
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri,contextPath+"/");
        String page = uri;
        if(begingWith(page,requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if (user==null){
                response.sendRedirect("login");
            }
        }

        return true;
    }

    private boolean begingWith(String page, String[] requireAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requireAuthPages) {
            if (StringUtils.startsWith(page,requiredAuthPage)){
                result = true;
                break;
            }
        }
        return result;


    }

}
