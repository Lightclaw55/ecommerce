package com.ecommerce.repositories;

import com.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository {
    User findByUsernameAndPassword(String username, String password);

    User findUserById(int id);

    List<User> findAllUser();

    User save(User u);

}
