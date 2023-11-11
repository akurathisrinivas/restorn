package com.auth.loginService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auth.loginService.entity.UserInfo;

import jakarta.transaction.Transactional;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
 
    Optional<UserInfo> findByName(String username); 
    
	/*
	 * @Transactional
	 * 
	 * @Query(
	 * value="SELECT  u.* FROM user_info u WHERE u.name = ?1 and u.password= ?2"
	 * ,nativeQuery=true) List<UserInfo> findUserDetails(String username,String
	 * password);
	 */
    
    @Transactional
	@Query(value="SELECT  u.* FROM user_info u WHERE u.name = ?1 and u.password= ?2",nativeQuery=true)
    List<UserInfo> findUserDetails(String username,String password);

}
