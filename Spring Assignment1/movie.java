package com.smk.springassignment1;

public class movie {
	String moviename;
	String actor;
	int budget;
	
	public movie()
	{
		
	}
	
	
	public movie(String moviename, String actor, int budget) {
		super();
		this.moviename = moviename;
		this.actor = actor;
		this.budget = budget;
	}
	
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "movie [moviename=" + moviename + ", actor=" + actor + ", budget=" + budget + "]";
	}
	
	

}
