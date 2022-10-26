package pe.maxz.springbootapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    int id;
    String title;
    String author;
}
