import java.util.ArrayList;
import java.util.List;

import controller.OwnerHelper;
import controller.OwnerPetDetailsHelper;
import model.Owner;
import model.Pet;
import model.PetList;

public class PetTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Owner Sally = new Owner("Justin");
		 OwnerHelper oh = new OwnerHelper();
		 
		 oh.insertOwner(Sally);
		 
		 List<Owner> allOwners = oh.showAllOwners();
		 for(Owner a: allOwners) {
			 System.out.println(a.toString());
		 }*/
		
		/*Owner terry = new Owner("Terry");
		
		OwnerHelper oh = new OwnerHelper();
		
		oh.insertOwner(terry);
		
		OwnerPetDetailsHelper opdh = new OwnerPetDetailsHelper();
		PetList terryPet = new PetList("Terry's Pets", terry);
		
		opdh.insertNewPetListDetails(terryPet);
		
		List<PetList> allLists = opdh.getLists();
		
		for (PetList a: allLists) {
			System.out.println(a.toString());
		}*/
		
		Owner susan = new Owner("Johnny");
		
		OwnerPetDetailsHelper opdh = new OwnerPetDetailsHelper();
		
		Pet wolfy =  new Pet("Wolfy", "Dog", "Johnny");
		Pet mrMeows = new Pet("Mr. Meows", "Cat", "Johhny");
		Pet ratnessEverdeen = new Pet("Ratniss Everdeen", "Rat", "Johnny");
		
		List<Pet> susansPets = new ArrayList<Pet>();
		susansPets.add(wolfy);
		susansPets.add(mrMeows);
		susansPets.add(ratnessEverdeen);
		
		PetList susansPetList = new PetList("Johhny's Pet List", susan);
		susansPetList.setListOfPets(susansPets);
		
		opdh.insertNewPetListDetails(susansPetList);
		
		List<PetList> allLists = opdh.getLists();
		for(PetList a: allLists) {
			System.out.println(a.toString());
		}

	}

}
