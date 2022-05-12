package com.mindtree.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer> {

    	
	@Query(value="select * from user where user_name=?1 and password=?2",nativeQuery=true)
	public UserDetails findByUserNameAndPassword(String userName, String password);
	
	
    @Transactional
	@Modifying
	@Query(value="insert into user(user_name,password,user_id) values (?1,?2,select nextval ('hibernate_sequence'))",nativeQuery=true)
	public void save(String userName, String password);


	public UserDetails findByUserName(String userName);

}

