package com.SpringMVC.springdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringMVC.springdemo.entity.CrewMember;
import com.SpringMVC.springdemo.service.CrewMemberService;

@Controller
@RequestMapping("/normandy")
public class CrewMemberController {

	@Autowired
	private CrewMemberService crewMemberService;
	
	
	@GetMapping("/crewmembers")
	public String listCrewMembers(Model theModel){
		
		List<CrewMember> crewMembers = crewMemberService.getCrewMembers(); 		
		
		theModel.addAttribute("members",crewMembers);
		
		return "list-crewMembers";
	}
	
	
	/// Test action for adding crew members to Normandy
	@PostMapping("/addmember")
	public String addMember(@ModelAttribute("member") CrewMember member){
		return null;
	}
}
