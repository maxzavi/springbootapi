package pe.maxz.springbootapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.maxz.springbootapi.entity.Book;
@Repository
public class BookRepository {
    ArrayList<Book> books = new ArrayList<Book>();

    public BookRepository(){
        books.add(new Book(1,"La casa verde", "Mario Vargas Llosa"));
        books.add(new Book(2,"Cien años de soledad", "Gabriel García Marquez"));
        books.add(new Book(3,"Memorias de una pulga", "Anonimo"));
    }
    
    public List<Book> getAll(){
        return books;
    }

    public Book getById(int id){
        Book result = null;
        if (id >= 1 && id<=3){
            result= books.get(id-1);
        }
        return result;
    }
}
