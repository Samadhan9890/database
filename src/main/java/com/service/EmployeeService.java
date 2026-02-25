package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository eresp;
	
	//save to add single record accpted using form
	public String addemployee(Employee e) {
		eresp.save(e);
		return "Employee record added Sucessfully";
	}
	//findall
	public List<Employee> findallemployee() {
		return eresp.findAll();
	}
	public Employee findbyempid(int empid) {
		return eresp.findById(empid).orElse(null);
	}
	//deletebyempid
	public String deletebyempid(int empid) {
		Employee exstingemp = eresp.findById(empid).orElse(null);
		if(exstingemp!=null) {
			eresp.deleteById(empid);
			return "Employee record deleted Sucessfully";
		}
		else {
			return "No matching record found for given empid";
		}
		
	}
	public String updatebyempid(int empid,Employee newemp) {
		Employee exstingemp = eresp.findById(empid).orElse(null);
		if(exstingemp==null) {
			return "No matching record found for give empid";
		}
		if(newemp.getFirstname()==null
				&&newemp.getMiddlename()==null
				&&newemp.getLastname()==null
				&&newemp.getAddress()==null
				&&newemp.getAdharno()==0
				&&newemp.getContactno()==0
				&&newemp.getDepartment()==null
				&&newemp.getDesignation()==null
				&&newemp.getDob()==null
				&&newemp.getEmail()==null
				&&newemp.getExp()==0
				&&newemp.getGender()==null
				&&newemp.getJoiningdate()==null
				&&newemp.getPanno()==null
				&&newemp.getProfile()==null
				&&newemp.getReportingmanager()==null
				&&newemp.getSalary()==0.0
				&&newemp.getStatus()==null
				&&newemp.getWorklocation()==null)
		{
			return "No new data provided for updation";
		}
		if(newemp.getFirstname()!=null) {
			exstingemp.setFirstname(newemp.getFirstname());
		}
		if(newemp.getMiddlename()!=null) {
			exstingemp.setMiddlename(newemp.getMiddlename());
		}
		if(newemp.getLastname()!=null) {
			exstingemp.setLastname(newemp.getLastname());
		}
		if(newemp.getAdharno()!=0) {
			exstingemp.setAdharno(newemp.getAdharno());
		}
		if(newemp.getAddress()!=null) {
			exstingemp.setAddress(newemp.getAddress());
		}
		if(newemp.getContactno()!=0) {
			exstingemp.setContactno(newemp.getContactno());
		}
		if(newemp.getDepartment()!=null) {
			exstingemp.setDepartment(newemp.getDepartment());
		}
		if(newemp.getDesignation()!=null) {
			exstingemp.setDesignation(newemp.getDesignation());
		}
		if(newemp.getDob()!=null) {
			exstingemp.setDob(newemp.getDob());
		}
		if(newemp.getExp()!=0) {
			exstingemp.setExp(newemp.getExp());
		}
		if(newemp.getEmail()!=null) {
			exstingemp.setEmail(newemp.getEmail());
		}
		if(newemp.getGender()!=null) {
			exstingemp.setGender(newemp.getGender());
		}
		if(newemp.getJoiningdate()!=null) {
			exstingemp.setJoiningdate(newemp.getJoiningdate());
		}
		if(newemp.getPanno()!=null) {
			exstingemp.setPanno(newemp.getPanno());
		}
		if(newemp.getProfile()!=null) {
			exstingemp.setProfile(newemp.getProfile());
		}
		if(newemp.getReportingmanager()!=null) {
			exstingemp.setReportingmanager(newemp.getReportingmanager());
		}
		if(newemp.getSalary()!=0.0) {
			exstingemp.setSalary(newemp.getSalary());
		}
		if(newemp.getStatus()!=null) {
			exstingemp.setStatus(newemp.getStatus());
		}
		if(newemp.getWorklocation()!=null) {
			exstingemp.setWorklocation(newemp.getWorklocation());
		}
		eresp.save(exstingemp);
		return "Employee record updated Sucessfully";
	}
	public List<Employee> findbyfirstname(String firstname){
		return eresp.findByFirstname(firstname);
	}
	public List<Employee> findbylastname(String lastname){
		return eresp.findByLastname(lastname);
	}
	public List<Employee> findbydepartment(String department){
		return eresp.findByDepartment(department);
	}
	public List<Employee> findbydesignation(String designation){
		return eresp.findByDesignation(designation);
	}

}
