package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Pet;
import model.PetList;

public class OwnerPetDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetLog");
	
	public void insertNewPetListDetails(PetList p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PetList> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<PetList> allDetails = em.createQuery("SELECT d FROM PetList d").getResultList();
		return allDetails;
	}
	
	public void removePetList(PetList toRemove) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Query typedQuery = em.createQuery("select p from PetList p where p.listName = :selectedListName or p.owner = :selectedOwner", PetList.class);

		typedQuery.setParameter("selectedName", toRemove.getListName());
		typedQuery.setParameter("selectedOwner", toRemove.getOwner());
		
		typedQuery.setMaxResults(1);
		
		PetList result = (PetList) typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Pet searchForPetById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet found=em.find(Pet.class, idToEdit);
		em.close();
		return found;
	}

}
