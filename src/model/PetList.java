package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="owners_pet_list")

public class PetList {
@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private Owner owner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="owners_pet_list", joinColumns= { @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID")}, inverseJoinColumns= { @JoinColumn(name="LIST_ID", referencedColumnName="ID", unique=true )})
	private List<Pet> listOfPets;
	
	
	public PetList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PetList(int id, String listName, Owner owner, List<Pet> listOfPets) {
		super();
		this.id = id;
		this.listName = listName;
		this.owner = owner;
		this.listOfPets = listOfPets;
	}
	
	public PetList(String listName, Owner owner, List<Pet> listOfPets) {
		this.listName = listName;
		this.owner = owner;
		this.listOfPets = listOfPets;
		
	}
	
	public PetList(String listName, Owner owner) {
		this.listName = listName;
		this.owner = owner;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getListName() {
		return listName;
	}


	public void setListName(String listName) {
		this.listName = listName;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public List<Pet> getListOfPets() {
		return listOfPets;
	}


	public void setListOfPets(List<Pet> listOfPets) {
		this.listOfPets = listOfPets;
	}


	@Override
	public String toString() {
		return "PetList [id=" + id + ", listName=" + listName + ", owner=" + owner + ", listOfPets=" + listOfPets + "]";
	}

	
	
	
	
	

}
