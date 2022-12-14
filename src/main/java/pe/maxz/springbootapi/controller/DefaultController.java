package pe.maxz.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.maxz.springbootapi.repository.DefaultRepository;

@RestController 
@RequestMapping (("/default/api/v1"))
public class DefaultController {
    @Autowired
    DefaultRepository defaultRepository;
    @GetMapping("/")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok(defaultRepository.get());
    }

}
