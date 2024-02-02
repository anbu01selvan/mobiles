package com.mobiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mobiles.entity.Mobile;

public interface MobileRepository extends JpaRepository <Mobile, Integer> {
///jpa query dont need to know the db details 
	@Query(value="select l from Mobile l")
	List<Mobile> getAllQuery();
	
	@Query(value="select m from Mobile m where m.price>:a and m.price<:b")
	public List<Object> gets(@Param("a") int a, @Param("b") int b); 


}
