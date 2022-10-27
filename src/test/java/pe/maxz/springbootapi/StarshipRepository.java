package pe.maxz.springbootapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.maxz.springbootapi.entity.Starship;
import pe.maxz.springbootapi.repository.StarshipRepositoryHttp;

@SpringBootTest
public class StarshipRepository {
    @Autowired
    StarshipRepositoryHttp starshipRepository;

    @Test
    public void getByID() throws Exception{
        Starship starship = new Starship();
        starship.setId(0);
        starship.setName("Star Destroyer");
        starship.setManufacturer("Kuat Drive Yards");

        Starship result = starshipRepository.get(3);
        assertEquals(result,starship);
    }
    @Test
    public void testNotExists() throws Exception{
        Starship result = starshipRepository.get(1000);
        assertEquals(result,null);
    }

}
