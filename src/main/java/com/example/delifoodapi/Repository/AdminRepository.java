package com.example.delifoodapi.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.delifoodapi.SignUpEntity.AdminUser;



@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Long> {

    Optional<AdminUser> findByRestrotantOwnerName(String RestaurantOwnerName);

}
