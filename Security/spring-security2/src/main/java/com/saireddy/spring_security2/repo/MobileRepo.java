package com.saireddy.spring_security2.repo;

import com.saireddy.spring_security2.model.Mobiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepo extends JpaRepository<Mobiles,Long>{
}
