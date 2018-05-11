package org.ocelot.musiclibrary.policy;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(MockitoJUnitRunner.class)
public class PolicyControllerStandAloneTest {

	private MockMvc mvc;
	
	@Mock
	private PolicyService service;
	
	@Before
	public void setup() throws Exception {
	    this.mvc = MockMvcBuilders.standaloneSetup(new PolicyController(this.service)).build();
	}
	
	@Test
	public void shouldTest() throws Exception {
		
		int policyNumber = 5;
	
		given(service.findPolicy(policyNumber)).willReturn(new Policy("Hugo", policyNumber));
		
		mvc.perform(MockMvcRequestBuilders
			.get("/policy/{policyNumber}", policyNumber).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.policyNumber", is(policyNumber)))
				.andExpect(jsonPath("$.name", is("Hugo")));
		
		verify(service).findPolicy(policyNumber);
		
	}
	
}
