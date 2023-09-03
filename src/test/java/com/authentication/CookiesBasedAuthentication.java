package com.authentication;

public class CookiesBasedAuthentication {
	
	/*
	 * A cookie is a small piece of data which the server sends back to the
	 * user's web browser. A browser may store it and send it back to the next request
	 * of the same server
	 * Typically, it is used to tell if two requests came from the same browser -
	 * keeping the user logged in
	 * Cookies authentication uses HTTP Cookies to authenticate client requests and
	 * maintain session information. It works as follow: The client sends a login request
	 * to the server
	 * On the successful login, the server responses includes the set cookie headers that contain
	 * the cookies name, value, expiry time and some other infos.
	 * 
	 * JSESSIONID
	 * If we're working with J2EE web applications, we will get the JSESSIONID cookie that
	 * used in server tracking
	 */

}
