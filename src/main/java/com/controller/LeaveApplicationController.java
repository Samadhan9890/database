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

import com.entity.LeaveApplication;
import com.service.LeaveApplicationService;

@RestController
@CrossOrigin
public class LeaveApplicationController {
	@Autowired
	LeaveApplicationService leserv;
	@PostMapping("/applyleave")
	public String applyforleave(@RequestBody LeaveApplication l) {
		return leserv.applyforleave(l);
	}
	@GetMapping("/findallleaves")
	public List<LeaveApplication>findallleaves(){
		return leserv.findallleaves();
	}
	@GetMapping("/findleavesbyempid")
	public List<LeaveApplication>findleavesbyempid(@RequestParam int empid){
		return leserv.findleavesbyempid(empid);
	}
	@DeleteMapping("/cancelleave")
	public String cancelleave(@RequestParam int leaveid) {
		return leserv.cancelleave(leaveid);
	}
	@PutMapping("/updateleave")
	public String updateleave(@RequestParam int leaveid,@RequestBody LeaveApplication newleave) {
		return leserv.updateleave(leaveid, newleave);
	}
	@PutMapping("/updateleavestatus")
	public String updateLeaveStatus(@RequestParam int leaveid, @RequestParam String status) {
		return leserv.updateLeaveStatus(leaveid, status);
	}

}
