package pe.maxz.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.maxz.springbootapi.entity.Product;
import pe.maxz.springbootapi.repository.ProductRepository;

@RestController
@RequestMapping ("/product/api/v1")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        try {
            Product product=productRepository.getById(id);
            if (product!=null) return ResponseEntity.ok(product);
            else return ResponseEntity.notFound().build();                
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
