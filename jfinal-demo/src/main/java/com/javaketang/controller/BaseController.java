package com.javaketang.controller;

import com.javaketang.interceptor.GlobalInerceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 
 * @author ygj
 *
 */
// @Before(GlobalInerceptor.class)
public class BaseController extends Controller {

	public void index(){
		render("index.html");
	}
	
}
