package com.saireddy.MobileShop.Repo;

import com.saireddy.MobileShop.model.Mobiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepo extends JpaRepository<Mobiles, String> {
}
