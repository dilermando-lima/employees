package com.project.employees.service;

import com.project.employees.constants.Auth;
import com.project.employees.constants.Err;
import com.project.employees.core.handle.ApiReturnException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {
    

   
    public String getKeyAccess() throws ApiReturnException {
        try {
			return Jwts.builder().setSubject( Auth.PUBLIC_COMMON_TOKEN)
					.signWith(SignatureAlgorithm.HS256, Auth.SECRET_TOKEN).compact();
		} catch (Exception e) {
			throw new ApiReturnException(HttpStatus.INTERNAL_SERVER_ERROR, Err.ERR_2_1);
        }
    }

}
