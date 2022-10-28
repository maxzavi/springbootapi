package pe.maxz.springbootapi;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StarshipControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testDefault() throws Exception {
		mockMvc.perform(get("/default/api/v1/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello world repo")));
	}
	@Test
	public void testNotFound() throws Exception {
		mockMvc.perform(get("/starship/api/v1/1"))
			.andDo(print())
			.andExpect(status().isNotFound());
	}
	@Test
	public void testGetIdOKName() throws Exception {
		mockMvc.perform(get("/starship/api/v1/9"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Death Star")));
	}
	@Test
	public void testGetIdOKManufacturer() throws Exception {
		mockMvc.perform(get("/starship/api/v1/12"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Incom Corporation")));
	}
}
