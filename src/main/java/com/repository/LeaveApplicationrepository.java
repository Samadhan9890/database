package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.LeaveApplication;
@Repository
public interface LeaveApplicationrepository extends JpaRepository<LeaveApplication,Integer> {
	//native Query to find all leaves apply by given empid
	@Query(value="select * from leave_application where employee_id=:empid",nativeQuery=true)
	public List<LeaveApplication>findleavesbyempid(int empid);

}
