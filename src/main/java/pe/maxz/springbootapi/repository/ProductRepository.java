package pe.maxz.springbootapi.repository;

import javax.sql.DataSource;

import pe.maxz.springbootapi.entity.Product;

public interface ProductRepository {
    public void setDataSource(DataSource dataSource);
    public Product getById(int id);
}
