package com.example.delifoodapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.delifoodapi.SignUpEntity.RegisterUserRole;

public interface RoleDao extends CrudRepository<RegisterUserRole, Long> {

}
