package pe.maxz.springbootapi.entity;

import lombok.Data;

@Data
public class Product {
    int id;
    String name;
    double price;
    String brandName;
}
