package com.SpringMVC.springdemo.crewmemberDAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringMVC.springdemo.entity.CrewMember;

@Repository
public class CrewMemberDAOImpl implements CrewMemberDAO {

	@Autowired	
	private SessionFactory sessionFactory;
	
	@Override
	public List<CrewMember> getCrewMembers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<CrewMember> theQuery = currentSession.createQuery("from normandycrew", CrewMember.class);
		
		List<CrewMember> crewMembers = theQuery.getResultList();
		
		return crewMembers;
		
	}

}
