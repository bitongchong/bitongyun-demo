package com.bitongyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAndTestController {
	@RequestMapping("/")
	public String show() {
		return "index";
	}
}
