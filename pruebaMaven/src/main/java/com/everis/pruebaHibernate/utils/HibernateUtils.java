package com.everis.pruebaHibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Generación de factoría de sesiones.
	 */
	static {

		try {

			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
			
		} catch (final Throwable ex) {

			// Error de inicialización.
			System.err.println("ERROR Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoría de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
