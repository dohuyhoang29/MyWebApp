package com.mycompany.respositories;

import com.mycompany.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
