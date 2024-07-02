package com.assignment.student_management.auth.repository;

import com.assignment.student_management.auth.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}