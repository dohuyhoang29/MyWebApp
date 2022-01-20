package com.mycompany.respositories;

import com.mycompany.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRespository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
    public Optional<User> findUserByEmail(String email);
}
