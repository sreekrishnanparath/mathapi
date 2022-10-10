package com.soj.math;

import com.soj.math.Service.MathService;
import com.soj.math.Service.MathServiceImpl;
import com.soj.math.controller.MathController;
import com.soj.math.dao.MathDao;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(MathController.class)
class MathControllerApplicationTests {


	@InjectMocks
	MathServiceImpl mathServiceImpl;

	@MockBean
	MathService mathService;

	@Mock
	public MathDao mathDao;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		RestAssuredMockMvc.mockMvc(mockMvc);
	}

	@Test
	void findAverageOfNumbers() {
		List<Long> numbers = Arrays.asList(1L,2L,3L);
		Mockito.when(mathDao.getAverage(numbers)).thenReturn(OptionalDouble.of(3.5));

		RestAssuredMockMvc
				.when()
				.get("/soj/math/median/1,2,3")
				.then()
				.statusCode(200);
	}

	@Test
	void findMedianOfNumbers() {
		List<Long> numbers = Arrays.asList(1L,2L,3L);
		Mockito.when(mathDao.getMedian(numbers)).thenReturn(OptionalDouble.of(2));

		RestAssuredMockMvc
				.when()
				.get("/soj/math/median/1,2,3")
				.then()
				.statusCode(200);
	}

	@Test
	void findMinOfNumbers() {
		List<Long> numbers = Arrays.asList(1L,2L,3L);
		Mockito.when(mathDao.getMinNumbers(numbers, 2)).thenReturn(Arrays.asList(1L));
		List<Long> result = mathServiceImpl.getMinNumbers(numbers, 2);
		assertEquals(Arrays.asList(1L), result);
	}


	@Test
	public void should_404_if_min_not_found() throws Exception {
		List<Long> numbers = Arrays.asList(1L,2L,3L);
		Mockito.when(mathDao.getMinNumbers(numbers, 5)).thenReturn(Arrays.asList(1L));
		RestAssuredMockMvc.when().get("/soj/math/min/5/1,2,3").then().statusCode(404);
	}

	@Test
	void findMaxOfNumbers() {
		List<Long> numbers = Arrays.asList(1L,2L,3L);
		Mockito.when(mathDao.getMaxNumbers(numbers, 5)).thenReturn(Arrays.asList(3L));
		List<Long> result = mathServiceImpl.getMaxNumbers(numbers, 5);
		assertEquals(Arrays.asList(3L), result);
	}


	@Test
	public void should_404_if_max_not_found() throws Exception {
		List<Long> numbers = Arrays.asList(1L,2L,3L);
		Mockito.when(mathDao.getMaxNumbers(numbers, 5)).thenReturn(Arrays.asList());
		RestAssuredMockMvc.when().get("/soj/math/max/5/1,2,3").then().statusCode(404);
	}

	@Test
	void findPercentileOfNumbers() {
		List<Long> numbers = Arrays.asList(55L,1L,10L,6L,78L,33L);
		Mockito.when(mathDao.getMaxNumbers(numbers, 100)).thenReturn(Arrays.asList(33L));
		List<Long> result = mathServiceImpl.getMaxNumbers(numbers, 100);
		assertEquals(Arrays.asList(33L), result);
	}


}
