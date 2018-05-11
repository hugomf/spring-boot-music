package org.ocelot.musiclibrary.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {
	
	private PolicyService service;
	
	@Autowired
	public PolicyController(final PolicyService service) {
		this.service = service;
	}
	
	@RequestMapping("/policy/{policyNumber}")
	public Policy getPolicy(@PathVariable int policyNumber) {
		return service.findPolicy(policyNumber);
	}

}
