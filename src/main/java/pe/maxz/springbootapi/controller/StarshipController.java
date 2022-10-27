package pe.maxz.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.maxz.springbootapi.entity.Starship;
import pe.maxz.springbootapi.repository.StarshipRepository;

@RestController
@RequestMapping("/starship/api/v1")
public class StarshipController {
    @Autowired
    StarshipRepository starshipRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Starship> getById(@PathVariable int id){
        try {
            Starship starship = starshipRepository.get(id);
            if (starship!=null) return ResponseEntity.ok(starship);
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
