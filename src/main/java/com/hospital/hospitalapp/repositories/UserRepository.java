package com.hospital.hospitalapp.repositories;

import java.util.ArrayList;

import com.hospital.hospitalapp.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByAge(Integer age);
}
