package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.LeaveApplication;
import com.repository.LeaveApplicationrepository;

@Service
public class LeaveApplicationService {
	@Autowired
	LeaveApplicationrepository lresp;
	
	//apply for leave
	public String applyforleave(LeaveApplication l) {
		lresp.save(l);
		return "Leave Applied sucessfully";
	}
	//find all leave details
	//for admin : to view all emplyee leaves
	public List<LeaveApplication>findallleaves(){
		return lresp.findAll();
	}
	
	public List<LeaveApplication>findleavesbyempid(int empid){
		return lresp.findleavesbyempid(empid);
	}
	//cancel leave
	public String cancelleave(int leaveid) {
		LeaveApplication exstingleave=lresp.findById(leaveid).orElse(null);
		if(exstingleave!=null) {
			lresp.deleteById(leaveid);
			return "Leave cancel Sucessfully";
		}
		else {
			return "No matching record found for given leaved"; 
		}
	}
	public String updateleave(int leaveid,LeaveApplication newleave) {
		LeaveApplication exstingleave=lresp.findById(leaveid).orElse(null);
		if(exstingleave==null) {
			return "No leave record found for given id";
		}
		if(newleave.getFirstname()==null&&newleave.getLastname()==null&&newleave.getReason()==null&&
				newleave.getFromdate()==null&&newleave.getTodate()==null) {
			return "No new data updated for leave updation updation failed";
		}
		if(newleave.getFirstname()!=null) {
			exstingleave.setFirstname(newleave.getFirstname());
		}
		if(newleave.getLastname()!=null) {
			exstingleave.setLastname(newleave.getLastname());
		}
		if(newleave.getReason()!=null) {
			exstingleave.setReason(newleave.getReason());
		}
		if(newleave.getFromdate()!=null) {
			exstingleave.setFromdate(newleave.getFromdate());
		}
		if(newleave.getTodate()!=null) {
			exstingleave.setTodate(newleave.getTodate());
		}
		lresp.save(exstingleave);
		return "Leave record Updated Sucessfully";

	}
	public String updateLeaveStatus(int leaveid, String status) {

        LeaveApplication exstingleave = lresp.findById(leaveid).orElse(null);

        if (exstingleave != null) {
         	exstingleave.setStatus(status.toLowerCase());
         	lresp.save(exstingleave);
        }

        return "Leave Status Updated Successfully";
    }
}
