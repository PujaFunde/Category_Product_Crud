package org.nimap.productmanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HomeController {
	
	@GetMapping("/")
	public String test() {
		System.out.println("in test application");
		return "test";
	}

}
