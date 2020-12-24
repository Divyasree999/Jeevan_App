package com.cg.jeevanonlineterminsurance.repository;
/*
 * Dao Layer
 * @author - Shahanaz
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.jeevanonlineterminsurance.entity.Customer;

@Repository
public interface CustomerDaoImpl extends JpaRepository<Customer, Integer> {
	@Query(value = "select * from customer where customer_id=?1", nativeQuery = true)
	Customer findByCustomerId(int customerId);

	

}
