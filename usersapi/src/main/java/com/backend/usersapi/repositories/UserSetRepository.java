package com.backend.usersapi.repositories;

import com.backend.usersapi.models.UserSet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface UserSetRepository extends MongoRepository<UserSet, Long> {
    UserSet findByUserIdentifier(String userIdentifier);

    List<UserSet> findAll();
}
