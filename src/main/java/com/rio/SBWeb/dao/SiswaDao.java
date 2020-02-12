package com.rio.SBWeb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rio.SBWeb.model.Siswa;
import com.rio.SBWeb.services.SiswaServices;

@Service
public class SiswaDao implements SiswaServices{

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	@Override
	public List<Siswa> listSiswas() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Siswa", Siswa.class).getResultList();
		
	}


	@Override
	public Siswa saveOrUpdate(Siswa siswa) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Siswa saved = em.merge(siswa);
		em.getTransaction().commit();
		return saved;
	}


	@Override
	public Siswa getId(Integer id_siswa) {
		EntityManager em = emf.createEntityManager();
		return em.find(Siswa.class, id_siswa);
	}


	@Override
	public void delete(Integer id_siswa) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Siswa.class, id_siswa));
		em.getTransaction().commit();
		
	}

}
