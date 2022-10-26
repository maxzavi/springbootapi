package pe.maxz.springbootapi.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultRepository {
    public String get (){
        return "Hello world repo";
    }
}
