package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity


@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="slist")
@JsonIgnoreType
public class Course extends BaseEntity {
	
	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}

	private String ctitle;
	private LocalDate start_date;
	private LocalDate end_date;
	private double fees;
	private double score;
	@OneToMany(mappedBy= "course", cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private List<Student> slist=new ArrayList<>();
	
	public boolean addstudent(Student s) {
		slist.add(s);
		s.setCourse(this);
		return true;
	}
	
	public boolean removestudent(Student s) {
		slist.remove(s);
		s.setCourse(null);
		return true;
	}
	
	
	
	
}
