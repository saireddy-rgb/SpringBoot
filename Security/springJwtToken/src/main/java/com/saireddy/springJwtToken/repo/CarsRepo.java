package com.saireddy.springJwtToken.repo;

import com.saireddy.springJwtToken.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepo extends JpaRepository<Cars,Long> {
}
