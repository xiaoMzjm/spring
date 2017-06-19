package com.wisely.highlight_springmvc4.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private DemoService demoSerivce;
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	MockHttpSession session;
	
	@Autowired
	MockHttpServletRequest request;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testNormalController() throws Exception {
	}
}
