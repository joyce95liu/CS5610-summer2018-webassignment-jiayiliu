package com.example.myapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String widgetType;
	private String text;
	private int size;
	private String name;
	private String link;
	private String listType;
	
	  public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	  @JsonIgnore
	  private Lesson lesson;
	
public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
public int getId() {
		return id;
	}
	public String getWidgetType() {
	return widgetType;
}
public void setWidgetType(String widgetType) {
	this.widgetType = widgetType;
}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
