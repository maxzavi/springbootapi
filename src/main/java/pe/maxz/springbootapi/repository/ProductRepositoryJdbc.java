package pe.maxz.springbootapi.repository;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.maxz.springbootapi.entity.Product;

@Repository
public class ProductRepositoryJdbc implements ProductRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public Product getById(int id) {
        Product product = null;
        String query = "select name,price,brandname from product where id=?";

        product=jdbcTemplate.query(query, 
            new Object[]{id},
            new int[]{Types.INTEGER},
            (ResultSet rs)->{
                Product result=null;
                if (rs.next()){
                    result= new Product();
                    result.setId(id);
                    result.setName(rs.getString("name"));
                    result.setPrice(rs.getDouble("price"));
                    result.setBrandName(rs.getString("brandname"));
                }
                return result;
            }
        );
        return product;
    }
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        String query = "select id, name, price, brandname from product";
        products = jdbcTemplate.query(query,
            (ResultSet rs)->{
                List<Product> results = new ArrayList<Product>();
                while(rs.next()){
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setBrandName(rs.getString("brandname"));
                    results.add(product);
                }
                return results;
            }
        );
        return products;
    }
    
}
