package pe.maxz.springbootapi.repository;

import java.sql.ResultSet;
import java.sql.Types;

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
    
}
