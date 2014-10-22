package com.lynas.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lynas.model.Team;
import com.lynas.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	
	
	
	@Autowired
	private SessionFactory session;

	@Transactional
	public void add(Team team) {
		session.getCurrentSession().save(team);
	}

	@Transactional
	public void update(Team team) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void delete(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Team getOne(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Team> getSelected(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
