package pe.maxz.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import pe.maxz.springbootapi.entity.Book;
import pe.maxz.springbootapi.repository.BookRepository;

@RestController
@RequestMapping("/book/api/v1")
@Tag(name = "Book Controller demo", description = "Book API v1")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @GetMapping("/")
    public ResponseEntity<List<Book>> getAll(){
        return  ResponseEntity.ok(bookRepository.getAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Book> get(@PathVariable int id){
        Book result = bookRepository.getById(id);
        if (result!=null) return ResponseEntity.ok(result);
        else return ResponseEntity.notFound().build(); 
    }
}
