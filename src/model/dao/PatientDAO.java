package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import model.domain.Patient;
import util.PublicCommon;

public class PatientDAO {
	
	@Test
	void pSelect() {
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		try {
			Patient p = em.find(Patient.class, "01a");
			
			System.out.println("이름 : " + p.getName());
			System.out.println("성별 : " + p.getGender());
			System.out.println("나이 : " + p.getAge());
			System.out.println("생일 : " + p.getBirth());
			System.out.println("번호 : " + p.getPhone());
			
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
		
//	@Test
	void pInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		     
		tx.begin();
		
		try {
			Patient patient = new Patient();
			patient.setPhone("010-999-9998");
		
		school.getStudents().add(s1);
		school.getStudents().add(s2);
		
		em.persist(school);
	    em.persist(s1);
	    em.persist(s2);
		
		tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
}
