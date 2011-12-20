package com.richfaces.session;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.richfaces.entity.Student;

@Stateful
public class StudentSession {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents(){

		List<Student> students = (List<Student>) em.createNamedQuery("findAllStudents").getResultList();
		return students;
	}
	
	public void createStudent(Student newStudent){
		try{
			em.persist(newStudent);
		}catch(Exception e){
			throw new EJBException(e.getMessage());
		}
	}
	
	public void removeStudent(Student currentStudent) {
        try {
        	Student student = em.find(Student.class, currentStudent.getId());
            em.remove(student);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
	}
	
	public void updateStudent(Student currentStudent){
		
		try{
			Student student = em.find(Student.class, currentStudent.getId());
			student.setName(currentStudent.getName());
			student.setGender(currentStudent.getGender());
			student.setAge(currentStudent.getAge());
			em.merge(student);
		}catch (Exception e){
			throw new EJBException(e.getMessage());
		}
	}
	
}
