package com.pxp.UserDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pxp.UserDatabase.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public boolean existsByCompanyNameAndPrice(String companyName, String price);

    public boolean existsById(int id);
}
