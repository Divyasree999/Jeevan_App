package com.cg.jeevanonlineterminsurance.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.jeevanonlineterminsurance.entity.Policy;

@Repository
public interface PolicyDaoImpl extends JpaRepository<Policy,Integer> {
	 @Query(value="select * from policy where policy_id=?1",nativeQuery=true)
	  Policy findByPolicyId(int policyId);
}
