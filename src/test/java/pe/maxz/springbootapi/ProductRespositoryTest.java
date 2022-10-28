package pe.maxz.springbootapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import pe.maxz.springbootapi.entity.Product;
import pe.maxz.springbootapi.repository.ProductRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc

public class ProductRespositoryTest {
    
    @Autowired
    ProductRepository productRepository;

    @BeforeAll
    private  void connect(){
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:jdbc/schema.sql")
            .addScript("classpath:jdbc/test-data.sql")
            .generateUniqueName(true)
            .build();
        productRepository.setDataSource(dataSource);
    }

    @Test
    public void testNull(){
        Product result =productRepository.getById(1);
        assertNotEquals(result, null);
    }

    @Test
    public void testFind(){
        Product product = new Product();
        product.setId(2);
        product.setName("Test2");
        product.setPrice(10.99);
        product.setBrandName("Acme");
        Product result = productRepository.getById(2);
        assertEquals(product,result);
    }

    @Test
    public void testList(){
        List <Product> results = productRepository.findAll();
        assertEquals(results.size(), 2);
    }

    @Test
    public void testListContains(){
        Product product = new Product();
        product.setId(2);
        product.setName("Test2");
        product.setPrice(10.99);
        product.setBrandName("Acme");
        List <Product> results = productRepository.findAll();
        assertEquals(results.get(1), product);
    }
}
