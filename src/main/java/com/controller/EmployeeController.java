package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	EmployeeService eserv;
	@PostMapping("/addemp")
	public String addemployee(@RequestBody Employee e) {
		return eserv.addemployee(e);
	}
	@GetMapping("/findallemp")
	public List<Employee> findallemp() {
		return eserv.findallemployee();
	}
	@GetMapping("/findbyempid")
	public Employee findbyempid(int empid) {
		return eserv.findbyempid(empid);
	}
	
	@DeleteMapping("/deletebyempid")
	public String deleteemployee(@RequestParam int empid) {
		return eserv.deletebyempid(empid);
	}
	@PutMapping("/updatebyempid")
	public String updateemployee(@RequestParam int empid,@RequestBody Employee newemp) {
		return eserv.updatebyempid(empid, newemp);
	}
	@GetMapping("/findbyfirstname")
	public List<Employee> findbyfirstname(@RequestParam String firstname) {
		return eserv.findbyfirstname(firstname);
	}
	@GetMapping("/findbylastname")
	public List<Employee> findbylastname(@RequestParam String lastname) {
		return eserv.findbylastname(lastname);
	}
	@GetMapping("/findbydepartment")
	public List<Employee> findbydepartment(@RequestParam String department) {
		return eserv.findbydepartment(department);
	}
	@GetMapping("/findbydesignation")
	public List<Employee> findbydesignation(@RequestParam String designation) {
		return eserv.findbydesignation(designation);
	}

}
