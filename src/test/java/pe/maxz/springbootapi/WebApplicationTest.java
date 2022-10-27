package pe.maxz.springbootapi;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.maxz.springbootapi.controller.PeopleController;

@SpringBootTest
public class WebApplicationTest {

    @Autowired
    public PeopleController peopleController;
    @Test
    public void contextLoads(){
        assertThat(peopleController).isNotNull();
    }
    
}
