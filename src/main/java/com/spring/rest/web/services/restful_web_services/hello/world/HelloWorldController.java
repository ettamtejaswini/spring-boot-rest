package com.spring.rest.web.services.restful_web_services.hello.world;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageService;
	
	public HelloWorldController(MessageSource messageService) {
		this.messageService = messageService;
	}
	
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloworld() {
		return "Hello World get";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HelloWorldBean");
	}
	
	@GetMapping(path="/hello-world-bean-pathvaraible/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("HelloWorldBean, %s", name));
	}
	

	@GetMapping(path="/hello-world-internalized")
	public String helloWorldI18n() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageService.getMessage("good.morning.message", null, "Default message", locale);
	}

}
