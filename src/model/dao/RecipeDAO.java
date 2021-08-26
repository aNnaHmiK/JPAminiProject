package model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

//import org.junit.jupiter.api.Test;

import model.entity.Recipe;
import util.PublicCommon;

public class RecipeDAO {
	
	private static RecipeDAO instance = new RecipeDAO();
	private RecipeDAO() {}
	public static RecipeDAO getInstance() {
		return instance;
	}

	// 1. 처방 생성
//	public void rInit(Recipe recipe) {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		tx.begin();
//
//		try {
//			Recipe r1 = new Recipe();
//			r1.setRName("독감");
//			r1.setPay("68,000원");
//			r1.setRx("해열제");
//
//			Recipe r2 = new Recipe();
//			r2.setRName("변비");
//			r2.setPay("20,000원");
//			r2.setRx("유산균");
//
//			em.persist(r1);
//			em.persist(r2);
//
//			tx.commit();
//
//			System.out.println("■ ■ ■ 저장 성공 ■ ■ ■");
//
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			em.close();
//			em = null;
//		}
//	}
	
	public static boolean rInit(Recipe recipe) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		

		tx.begin();

		try {
			Recipe r1 = new Recipe();
			r1.setRName("독감");
			r1.setPay("68,000원");
			r1.setRx("해열제");

			Recipe r2 = new Recipe();
			r2.setRName("변비");
			r2.setPay("20,000원");
			r2.setRx("유산균");

			em.persist(r1);
			em.persist(r2);

			tx.commit();

//			System.out.println("■ ■ ■ 저장 성공 ■ ■ ■");
			
			int result = 
			
			if(result == 1) {
				return true;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return false;
	}

	// 2. 전체 처방 조회
	public static ArrayList<Recipe> rSelectAll() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<Recipe> list = null;

		tx.begin();
		try {
			list = (ArrayList<Recipe>)em.createNamedQuery("recipe.findAll").getResultList();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return list;
	}
	
	

	// 3. 특정 처방 조회
//   @Test
	public void rSelectOne() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r = (Recipe)em.createNamedQuery("recipe.findByname")
								 .setParameter("rName", "독감")
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

	// 4. 처방 가격 수정
//   @Test
	public void rChange() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r = (Recipe) em.createNamedQuery("recipe.findByname")
								  .setParameter("rName", "독감")
								  .getSingleResult();
			r.setPay("6,800원");

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

	// 5. 처방 삭제
//	@Test
	public void rDelete() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Recipe r = (Recipe) em.createNamedQuery("recipe.findByname")
								  .setParameter("rName", "변비")
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
	
	@Test
	public void unitTest() {
		
		System.out.println("1.생성");
//		rInit();
		
		System.out.println("2.전체");
		ArrayList<Recipe> all = rSelectAll();
		System.out.println(all);
	}

}
