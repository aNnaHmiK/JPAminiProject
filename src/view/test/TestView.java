package view.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.domain.Emp;
import util.PublicCommon;

public class TestView {
	@Test
	void namedQuery() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		em.close();
		em = null;
	}

}
