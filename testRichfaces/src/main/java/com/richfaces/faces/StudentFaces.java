package com.richfaces.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.richfaces.entity.Student;
import com.richfaces.session.StudentSession;

@ManagedBean
@SessionScoped
public class StudentFaces implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	StudentSession studentSession;
	
	//private String currentStudentID;
    private Student editedStudent;
    private int page = 1;
    
    @Inject
	Student newStudent;
    
	private List<Student> students;
	
	public void create(){
		studentSession.createStudent(newStudent);
		page = currentPage();
		init();
		
	}
	
	public void remove(){
		studentSession.removeStudent(editedStudent);
		init();
	}
	
	public void update(){
		
		studentSession.updateStudent(editedStudent);
		init();
	}

	public Student getEditedStudent() {
		return editedStudent;
	}

	public void setEditedStudent(Student editStudent) {
		this.editedStudent = editStudent;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	 public Student getNewStudent() {
		return newStudent;
	}

	public void setNewStudent(Student student) {
		this.newStudent = student;
	}

	//@Produces
	//@StudentList
	public List<Student> getStudents() {
		init();
		return this.students;
	}
	
	public void init(){
		List<Student> list = new ArrayList<Student>();
		list = studentSession.getAllStudents();
		
		if(students != null){
			students.clear();
		}else{
			students = new ArrayList<Student>();
		}
		
		for(Student s : list){
			students.add(s);
		}
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	//List util
	public void addStudentList(){
		if(newStudent != null){
			students.add(newStudent);
			page = currentPage();
		}
	}
	
	public void updateStudentList(){
		
		int index_student = containStudent();
		
		if(index_student != -1){
			students.get(index_student).setName(editedStudent.getName());
			students.get(index_student).setGender(editedStudent.getGender());
			students.get(index_student).setAge(editedStudent.getAge());
		}
		
	}
	
	public void removeStudentList(){
		
		int index_student = containStudent();
		
		if(index_student != -1){
			students.remove(index_student);
		}
		
	}
	
	public int containStudent(){
		
		for(int i = 0 ; i < students.size(); i++){
			if(students.get(i).getId().equals(editedStudent.getId())){
				return i;
			}
		}
		
		return -1;
	} 
	
	public int currentPage(){
		int size = students.size();
		int currentPage = 1;
		
		if(size%5 != 0){
			currentPage = size/5 + 1;
		}else{
			currentPage = size/5;
		}
		
		return currentPage;
	}
	
}
