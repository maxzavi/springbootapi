package pe.maxz.springbootapi.repository;

import pe.maxz.springbootapi.entity.Starship;

public interface StarshipRepository {
    public Starship get(int id) throws Exception;
}
