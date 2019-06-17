package com.stackroute.accountmanager.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stackroute.accountmanager.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getUserId()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		Map<String, String> jwtMap = new HashMap<String, String>();
		jwtMap.put("token", jwtToken);
		jwtMap.put("message", "User successfully logged in");
		return jwtMap;
	}

}
