package model.dao;

import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Desk;
import model.domain.Patient;
import util.PublicCommon;

public class DeskDAO {

	@Test
	void init() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		long time = System.currentTimeMillis();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		String t = simple.format(time);
		
		try {
			Desk desk = new Desk();
			desk.setDName("피부과");
			desk.setDate(t);
			
			Patient p1 = new Patient();
			p1.setName("박모모");
			p1.setGender("F");
			p1.setAge("3Y");
			p1.setBirth("19.08.12");
			p1.setPhone("010-888-8888");
//			p1.getDesks().add(desk);
			
			em.persist(desk);
			em.persist(p1);
			
			tx.commit();
			
//			System.out.println(p1.getDID());
//			System.out.println(p1.getDID().getDName());
			System.out.println(em.createNamedQuery("Patient.findAll"));
//			List<Patient> all = em.createNamedQuery("Patient.findAll").getResultList();
//			all.forEach(v -> System.out.println(v));
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

}