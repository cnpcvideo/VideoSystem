package com.cdi.producer.field;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class UserDatabaseEntityManager {
	@Produces
	@PersistenceContext
	@UserDatabase
	private EntityManager em;
	
	/*@PersistenceContext
	private EntityManager em;
	
	@Produces
	@UserDatabase
	public EntityManager create() {
		return em;
	}

	public void close(@Disposes @UserDatabase EntityManager em) {
		em.close();
	}*/
}
