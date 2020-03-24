package com.aistar.dao.impl;

import com.aistar.dao.ProductDao;
import com.aistar.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//等价于  <bean id="productDaoImpl" class="com.aistar.dao.impl.ProductDaoImpl"></bean>
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean insert(Product product) {
        String sql = "insert into product(pro_id,pro_name,pro_num,pro_size,pro_color,pro_price" +
                ",pro_address,pro_date,pro_status) values(?,?,?,?,?,?,?,?,?) ";
        Object[] args={product.getProId(),product.getProName(),product.getProNum(),product.getProSize(),product.getProColor(),
                product.getProPrice(),product.getProAddress(),product.getProDate(),1};

        return jdbcTemplate.update(sql,args)>0;
    }

    @Override
    public boolean update(Product product) {
        String sql = "update product set pro_name=?,pro_num=?,pro_size=?,pro_color=?" +
                ",pro_price=?,pro_address=?,pro_date=? where pro_id=?";
        Object[] args={product.getProName(),product.getProNum(),product.getProSize(),product.getProColor(),
        product.getProPrice(),product.getProAddress(),product.getProDate(),product.getProId()};
        return jdbcTemplate.update(sql,args)>0;
    }

    @Override
    public boolean delete(String proId) {
        String sql = "update product set pro_status=0 where pro_id=?";
        Object[] args = {proId};

        return jdbcTemplate.update(sql,args)>0;
    }

    @Override
    public Product selectByPrimaryKey(String proId) {

        String sql = "select * from product where pro_id = ?";
        Object[] args = {proId};
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        Product product = jdbcTemplate.queryForObject(sql,args,rowMapper);
        return product;
    }

    @Override
    public List<Product> selectAll() {
        System.out.println("dao selectAll");
        String sql = "select * from product";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        List<Product> productList = jdbcTemplate.query(sql,rowMapper);
        return productList;
    }
}
