package com.project.employees.core.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.employees.annotations.AuthType;
import com.project.employees.constants.Auth;
import com.project.employees.constants.Err;
import com.project.employees.core.handle.ApiReturnException;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Jwts;


@Component
public class RequestInterceptor  implements HandlerInterceptor  {

    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ApiReturnException {
    	if (handler instanceof HandlerMethod) {
			
            HandlerMethod method = (HandlerMethod) handler;	
            /*====================== Verify protected resources by AUTH_TYPE ==============*/
		    if(   method.getMethod().isAnnotationPresent(AuthType.class) ){	
                if(   ArrayUtils.contains( method.getMethod().getAnnotation(AuthType.class).value() , AuthType.AUTH_SIMPLE)){
                    validateKeyAccess(request);
                }
            }
            
        }

                
        return true;
    }


    private void validateKeyAccess(HttpServletRequest request) throws ApiReturnException {

        if( request.getHeader(Auth.HEADER_AUTH_NAME) == null  ) 
        throw new ApiReturnException(HttpStatus.UNAUTHORIZED, Err.ERR_2_2);

        if(  !Auth.PUBLIC_COMMON_TOKEN.equals(
                Jwts.parser().setSigningKey(Auth.SECRET_TOKEN)
                .parseClaimsJws(request.getHeader(Auth.HEADER_AUTH_NAME)).getBody().getSubject()))
        throw new ApiReturnException(HttpStatus.UNAUTHORIZED, Err.ERR_2_2);
			
    }
    
}
