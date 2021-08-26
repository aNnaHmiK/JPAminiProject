package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.Patient;
import util.PublicCommon;

public class PatientDAO {
	
	private static PatientDAO instance = new PatientDAO();
	private PatientDAO() {}
	public static PatientDAO getInstance() {
		return instance;
	}
	
	// 1. 환자 생성
//  @Test
	public void pInit() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient p1 = new Patient();
			p1.setPName("이건우");
			p1.setGender("M");
			p1.setAge("5Y");
			p1.setBirth("17.06.12");
			p1.setPhone("010-111-1111");

			Patient p2 = new Patient();
			p2.setPName("마슈슈");
			p2.setGender("F");
			p2.setAge("17Y");
			p2.setBirth("05.06.26");
			p2.setPhone("010-222-2222");

			Patient p3 = new Patient();
			p3.setPName("김만두");
			p3.setGender("M");
			p3.setAge("8Y");
			p3.setBirth("13.08.08");
			p3.setPhone("010-333-3333");

			Patient p4 = new Patient();
			p4.setPName("이제시");
			p4.setGender("F");
			p4.setAge("6Y");
			p4.setBirth("15.09.25");
			p4.setPhone("010-444-4444");

			Patient p5 = new Patient();
			p5.setPName("임쿠키");
			p5.setGender("F");
			p5.setAge("5Y");
			p5.setBirth("16.03.19");
			p5.setPhone("010-555-5555");

			Patient p6 = new Patient();
			p6.setPName("정치즈");
			p6.setGender("M");
			p6.setAge("5Y");
			p6.setBirth("16.08.24");
			p6.setPhone("010-666-6666");

			Patient p7 = new Patient();
			p7.setPName("조하운");
			p7.setGender("M");
			p7.setAge("27Y");
			p7.setBirth("95.04.10");
			p7.setPhone("010-777-7777");

			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.persist(p4);
			em.persist(p5);
			em.persist(p6);
			em.persist(p7);

			tx.commit();

			System.out.println("■ ■ ■ 저장 성공 ■ ■ ■");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 2. 전체 환자 조회
//	@Test
	public void pSelectAll() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			em.createNamedQuery("patient.findAll").getResultList().forEach(v -> System.out.println(v));

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 3. 특정 환자 조회
//  @Test
	public void pSelectOne() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient r = (Patient) em.createNamedQuery("patient.findByname")
									.setParameter("pName", "마슈슈")
									.getSingleResult();
			System.out.println(r);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 4. 환자 연락처 수정
//  @Test
	public void pChange() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient r = (Patient) em.createNamedQuery("patient.findByname")
									.setParameter("pName", "마슈슈")
									.getSingleResult();
			r.setPhone("010-020-0202");

			tx.commit();

			System.out.println("■ ■ ■ 수정 성공 ■ ■ ■");
			System.out.println(r);

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

	// 5. 환자 삭제
//	@Test
	public void pDelete() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Patient r = (Patient) em.createNamedQuery("patient.findByname")
									.setParameter("pName", "마슈슈")
									.getSingleResult();
			em.remove(r);

			tx.commit();

			System.out.println("■ ■ ■ 삭제 성공 ■ ■ ■");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
	}

}