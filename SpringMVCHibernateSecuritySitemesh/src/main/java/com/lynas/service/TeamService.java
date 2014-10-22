package com.lynas.service;

import java.util.List;

import com.lynas.model.Team;

public interface TeamService {
	public void add(Team team);
	public void update(Team team);
	public void delete(int userId);
	public Team getOne(int userId);
	public List<Team> getAll();
	public List<Team> getSelected(String query);

}
