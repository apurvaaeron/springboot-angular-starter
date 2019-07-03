package com.apurvaaeron.springboot.angular.repositories;

import com.apurvaaeron.springboot.angular.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}
