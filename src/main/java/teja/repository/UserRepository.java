package teja.repository;

import teja.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<AppUser, Integer>{
	
	@Query("select v from AppUser v where v.email = :email")
	public AppUser getUserByEmail(@Param("email") String email);
	
	

	
}
