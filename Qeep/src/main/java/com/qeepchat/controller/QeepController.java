package com.qeepchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QeepController {
	@RequestMapping("/")
	public String getindex(){
		return"index";
	}

}




