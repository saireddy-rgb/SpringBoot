package com.saireddy.springJwtToken.repo;

import com.saireddy.springJwtToken.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<UsersModel,Long> {
    Optional<UsersModel> findByUsername(String username);
    Boolean existByUsername(String username);

}
