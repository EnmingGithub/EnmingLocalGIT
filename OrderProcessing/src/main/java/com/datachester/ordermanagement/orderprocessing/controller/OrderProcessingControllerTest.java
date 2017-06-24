package com.datachester.ordermanagement.orderprocessing.controller;

import com.datachester.ordermanagement.orderprocessing.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class OrderProcessingControllerTest {

	private MockMvc mockMvc;

	@Mock
	private TestService testService;

	@InjectMocks
	OrderProcessingController testController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
	}

	@Test
	public void testSave() throws Exception {
		mockMvc.perform(post("/ordering").param("121", "1st").contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testDeleteOrderDB() throws Exception {
		mockMvc.perform(delete("/cancel").param("121", "1st").contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetOrderDB() throws Exception {
		when(testService.query("121")).thenReturn("Succed!");
		mockMvc.perform(get("/ordering/121").param("orderid", "121")).andDo(print());
		verify(testService).query("121");
	}

	@Test
	public void testGetOrderStatus() throws Exception {
		ResultActions perform = mockMvc.perform(get("/status/{OrderID}", "121"));
		perform.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.OrderID").value("121"));
	}

	@Test
	public void testFindAll() throws Exception {
		ResultActions perform = mockMvc.perform(get("/history"));
		perform.andExpect(status().isOk());
	}

	@Test
	public void testCountAll() throws Exception {
		ResultActions perform = mockMvc.perform(get("/total"));
		perform.andExpect(status().isOk());
	}

	@Test
	public void testShip() throws Exception {
	ResultActions perform = mockMvc.perform(
		      get("/ship/{OrderID}", "121"));
		  perform.andExpect(status().isOk());
	}

	@Test
	public void testDeliver() throws Exception {
		ResultActions perform = mockMvc.perform(
			      get("/deliver/{OrderID}", "121"));
			  perform.andExpect(status().isOk());
	}

}
