package com.example.empik.domain.repository;

import com.example.empik.domain.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitUserRepository extends JpaRepository<GitUser, String> {

    GitUser findByLogin(String login);

}
