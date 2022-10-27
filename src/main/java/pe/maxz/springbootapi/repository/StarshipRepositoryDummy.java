package pe.maxz.springbootapi.repository;


import pe.maxz.springbootapi.entity.Starship;
public class StarshipRepositoryDummy implements StarshipRepository{
    @Override
    public Starship get(int id) {
        Starship starship = new Starship();
        starship.setId(id);
        starship.setName("Star Destroyer");
        return starship;    
    }
}
