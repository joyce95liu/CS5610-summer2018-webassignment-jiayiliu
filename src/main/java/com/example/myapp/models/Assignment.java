package com.example.myapp.models;


import javax.persistence.Entity;


@Entity
public class Assignment extends Widget{

	private String points;
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	private String title;
	private String description;
	private String essay;
	private String file;
	private String link;
		
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}


