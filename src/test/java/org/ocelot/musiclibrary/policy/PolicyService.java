package org.ocelot.musiclibrary.policy;

import org.springframework.stereotype.Service;

@Service
public class PolicyService {

	public Policy findPolicy(final int policyNumber) {
		if (policyNumber > 5) { 
			return new Policy("Hugo", policyNumber); 
		}
		return new Policy("Invalid", policyNumber);
	}
}


