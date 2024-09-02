package com.spring.rest.web.services.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getPersonName() {
		return new PersonV1("Jack Bob");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonFullName() {
		return new PersonV2(new Name("Jack", "Bob"));
	}
}
