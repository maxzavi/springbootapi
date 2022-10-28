package pe.maxz.springbootapi;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import pe.maxz.springbootapi.repository.ProductRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    private void connect(){
        DataSource dataSource = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("jdbc/schema.sql")
            .addScript("jdbc/test-data.sql")
            .generateUniqueName(true)
            .build();
        productRepository.setDataSource(dataSource);
    }

    @Test
	public void testNotFound() throws Exception {
		mockMvc.perform(get("/product/api/v1/4"))
            .andDo(print())
            .andExpect(status().isNotFound());
	}

    @Test
    public void testFindById() throws Exception{
        mockMvc.perform(get("/product/api/v1/2")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$['name']",is("Test2")))
            .andExpect(jsonPath("$['price']",is(10.99)))
            .andExpect(jsonPath("$['brandName']",is("Acme")))
            ;
    }

    @Test
    public void testFindAll() throws Exception{
        mockMvc.perform(get("/product/api/v1/")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[1].name",is("Test2")))
            .andExpect(jsonPath("$[0].brandName",is("LG")))
            .andExpect(jsonPath("$[0].price",is(1899.0)))
            ;
    }
}
