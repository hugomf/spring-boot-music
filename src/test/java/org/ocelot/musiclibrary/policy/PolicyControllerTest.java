package org.ocelot.musiclibrary.policy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(PolicyController.class)
public class PolicyControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private PolicyService service;
	
	@Test
	public void shouldTest() throws Exception {
		
		int policyNumber = 5;
	
		when(service.findPolicy(policyNumber)).thenReturn(new Policy("Hugo", policyNumber));
		
		mvc.perform(MockMvcRequestBuilders
			.get("/policy/{policyNumber}", policyNumber).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.policyNumber", equalTo(policyNumber)))
				.andExpect(jsonPath("$.name", equalTo("Hugo")));
		
		verify(service).findPolicy(policyNumber);
		
	}
	
}
