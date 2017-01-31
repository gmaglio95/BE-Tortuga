package org.tortuga.rest.api2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

	@RequestMapping("/")
	@ResponseBody
	public String invoke() {
		return "'prova' : 'ciao'";
	}
}
