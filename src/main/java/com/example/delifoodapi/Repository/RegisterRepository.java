package com.example.delifoodapi.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.delifoodapi.SignUpEntity.RegisterUser;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterUser, Long> {
   


	Optional<RegisterUser> findByUserName(String userName);
	

    
}
