package com.richfaces.faces;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.richfaces.entity.Student;
import com.richfaces.session.StudentSession;

@ManagedBean
@RequestScoped
public class StudentListFaces {
	
	@EJB
	StudentSession studentSession;
	
	private List<Student> students;

	public List<Student> getStudents() {
		students = studentSession.getAllStudents(); 
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
