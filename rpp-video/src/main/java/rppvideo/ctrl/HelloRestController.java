package rppvideo.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	
	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World";
	}
}
