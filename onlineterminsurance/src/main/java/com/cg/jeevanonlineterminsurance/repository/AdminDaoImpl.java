package com.cg.jeevanonlineterminsurance.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.jeevanonlineterminsurance.entity.Admin;
/*
 * Dao Layer
 * @author - Poorani
 */
@Repository
public interface AdminDaoImpl extends JpaRepository<Admin, Integer>{
	@Query(value = "select * from admin where admin_id=?1", nativeQuery = true)
	Admin findByAdminId(int adminId);
}
