package com.datachester.ordermanagement.orderprocessing;

import com.datachester.ordermanagement.orderprocessing.controller.OrderProcessingController;
import com.datachester.ordermanagement.orderprocessing.entity.OrderEntity;
import com.datachester.ordermanagement.orderprocessing.repo.OrderRepository;
import com.datachester.ordermanagement.orderprocessing.service.*;
import com.datachester.ordermanagement.orderprocessing.vo.OrderResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.jayway.jsonpath.JsonPath;
import static com.jayway.jsonassert.JsonAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

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
		mockMvc.perform(post("/ordering").param("121", "1st").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteOrderDB() throws Exception {
		mockMvc.perform(delete("/cancel").param("121", "1st").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetOrderDB() throws Exception {
		OrderResponse first = new OrderResponse();
		first.setOrderID("121");
		first.setName("1st");
		first.setStatus(new OrderEntity().getStatus());
		first.setDate(new OrderEntity().getDate());
		
		when(testController.getOrderDB("121")).thenReturn(first);
		mockMvc.perform(get("/ordering/{OrderID}","121"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].OrderID", is("121")))
				.andExpect(jsonPath("$[0].Name", is("1st")));
		verify(testController, times(1)).getOrderDB("121");
	}

	@Test
	public void testGetOrderStatus() throws Exception {
		ResultActions perform = mockMvc.perform(get("/status/{OrderID}", "121"));
		perform.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.OrderID").value("121"));
	}

	@Test
	public void testFindAll() throws Exception {
		OrderEntity first = new OrderEntity();
		first.setOrderID("121");
		first.setName("1st");
		/*
		 * OrderEntity second = new OrderEntity(); second.setOrderID("122");
		 * second.setName("2nd");
		 */
	//	when(testController.findAll()).thenReturn(Arrays.asList(first));
		mockMvc.perform(get("/history")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].OrderID", is("121")))
				.andExpect(jsonPath("$[0].Name", is("1st")));
		verify(testController, times(1)).findAll();
		verifyNoMoreInteractions(testController);
	}

	@Test
	public void testCountAll() throws Exception {

		ResultActions perform = mockMvc.perform(get("/total"));
		perform.andExpect(status().isOk());
	}

	@Test
	public void testShip() throws Exception {
		OrderEntity first = new OrderEntity();
		first.setOrderID("121");
		first.setName("1st");
		//when(testController.ship("121")).thenReturn(Arrays.asList(first));
		ResultActions perform = mockMvc.perform(get("/ship/{OrderID}", "121"));
		perform.andExpect(status().isOk());
	}

	@Test
	public void testDeliver() throws Exception {
		ResultActions perform = mockMvc.perform(get("/deliver/{OrderID}", "121"));
		perform.andExpect(status().isOk());
	}

}
