package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pet;

public class PetHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetLog");

	public void insertPet(Pet p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pet>showAllPets(){
		EntityManager em = emfactory.createEntityManager();
		List<Pet> allPets = em.createQuery("SELECT i FROM Pet i").getResultList();
			return allPets;
	}
	
	public void removePet(Pet toRemove) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.petName = :selectedName and p.petType = :selectedType and p.petOwner = :selectedOwner", Pet.class);
		
		typedQuery.setParameter("selectedName", toRemove.getName());
		typedQuery.setParameter("selectedType", toRemove.getType());
		typedQuery.setParameter("selectedOwner", toRemove.getOwner());
		
		typedQuery.setMaxResults(1);
		
		Pet result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updatePet(Pet toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pet> searchForPetByName(String petName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.petName = :selectedName", Pet.class);
		typedQuery.setParameter("selectedName", petName);
		//Pet found = em.find(Pet.class, petName);
		
		List<Pet> found = typedQuery.getResultList();
		em.close();
		return found;
		
	}
	
	public void cleanUp() {
		emfactory.close();
	}

	public List<Pet> searchForPetByOwner(String petOwner) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select p from Pet p where p.petOwner = :selectedOwner", Pet.class);
		typedQuery.setParameter("selectedOwner", petOwner);
		
		List<Pet> found = typedQuery.getResultList();
		em.close();
		return found;
	}

	public Pet searchForPetById(int petEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet found = em.find(Pet.class, petEdit);
		em.close();
		return found;
	}
	
}