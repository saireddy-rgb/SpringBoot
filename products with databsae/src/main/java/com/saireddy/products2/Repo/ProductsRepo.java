package com.saireddy.products2.Repo;

import com.saireddy.products2.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {

}
