package pe.maxz.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import pe.maxz.springbootapi.entity.People;
import pe.maxz.springbootapi.repository.PeopleRepository;

@RestController
@RequestMapping("/people/api/v1")
@Tag(name = "Star Wars People", description = "API peoples of Star Wars")

public class PeopleController {
    @Autowired
    PeopleRepository peopleRepository;
    @GetMapping("/{id}")
    public ResponseEntity<People> get (@PathVariable int id){
        People people = peopleRepository.getById(id);
        if (people!=null) return ResponseEntity.ok(people);
        else return ResponseEntity.notFound().build();
    }
}
