package com.lmsMgmt.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lmsMgmt.models.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
	
	@Query("select u from User u where username = :username")
    public User findByUsername(String username);
	
		

}
