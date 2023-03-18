package com.mindtree.moviewebapp.exception;

public class AppException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3040654309600303578L;

	public AppException(String str)  
    {  
        System.err.println(str);
    } 

}