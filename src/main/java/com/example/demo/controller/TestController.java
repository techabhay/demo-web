package com.example.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
XEBIA:YBL
@author ABHAY MISHRA
 */

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping(path = "/msg")  
	public String getString(HttpSession session, HttpServletRequest request) {
		System.out.println("CurrentUrl : " + request.getRequestURL());
		return "Hi Success";
	}

	@GetMapping(path = "/setSession")  
	public void foo(HttpSession session, HttpServletRequest request) {
		System.out.println("CurrentUrl : " + request.getRequestURL());
		String sessionId = session.getId(); 
		session.setMaxInactiveInterval(10);
		System.out.println("sessionId :::::::::: " + sessionId);
	}

	@GetMapping(path = "/setCookie")  
	public void setCookie(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		session.setMaxInactiveInterval(10);
		Cookie cookie = new Cookie("username", "Jovan");

		response.addCookie(cookie);
		System.out.println("sessionId :::::::::: " + sessionId);
	}
}
