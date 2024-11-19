package com.cipriano.omoi.repository;

import com.cipriano.omoi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> { }
