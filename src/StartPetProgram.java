import java.util.List;
import java.util.Scanner;

import controller.PetHelper;
import model.Pet;

public class StartPetProgram {
	
	static Scanner in = new Scanner(System.in);
	static PetHelper ph = new PetHelper();
	
	private static void addPet() {
		System.out.print("Enter pets name: ");
		String petName = in.nextLine();
		System.out.print("Enter pet type: ");
		String petType = in.nextLine();
		System.out.print("Enter pet Owner: ");
		String petOwner = in.nextLine();
		Pet toAdd = new Pet(petName, petType, petOwner);
		ph.insertPet(toAdd);

	}
	
	private static void removePet() {
		System.out.print("Enter the pet to remove from list: ");
		String pet = in.nextLine();		
		System.out.println("Enter type to be removed from list: ");
		String type = in.nextLine();
		System.out.println("Enter owner to remove from list: ");
		String owner = in.nextLine();
		Pet toRemove = new Pet(pet, type, owner);
		ph.removePet(toRemove);
	}
	
	private static void viewPetList() {
		List<Pet>allPets = ph.showAllPets();
		for(Pet singlePet : allPets) {
			System.out.println(singlePet.returnPetDetails());
		}
	}
	
	private static void editPet() {
		System.out.println("Press 1 to search by pet name");
		System.out.println("Press 2 to search by pet owner");
		int userChoice = in.nextInt();
		in.nextLine();
		List<Pet> found;
		if (userChoice == 1) {
			System.out.print("Enter the pets name: ");
			String petName = in.nextLine();
			found = ph.searchForPetByName(petName);
		} else {
			System.out.print("Enter the pet owner: ");
			String petOwner = in.nextLine();
			found = ph.searchForPetByOwner(petOwner);

		}
		
		if(!found.isEmpty()) {
			System.out.println("Found Results:");
			for(Pet p : found) {
				System.out.println(p.getId() + " : " + p.toString());				
			}
			System.out.print("Which pet ID to edit?  ");
			int petIdToEdit = in.nextInt();
			
			Pet petEdit = ph.searchForPetById(petIdToEdit);
			System.out.println(petEdit.getName() + " is owned by " + petEdit.getOwner());
			System.out.println("Press 1 to edit pets name");
			System.out.println("Press 2 to edit the pets owner");
			int selection = in.nextInt();
			in.nextLine();
			
			if(selection == 1) {
				System.out.println("Please enter the pets new name: ");
				String newPetName = in.nextLine();
				petEdit.setName(newPetName);
			}
			else if (selection == 2){
				System.out.println("Please enter the pets new owner: ");
				String newPetOwner = in.nextLine();
				petEdit.setOwner(newPetOwner);
				}
			ph.updatePet(petEdit);
			}
		else {
			System.out.println("***** Nothing found *****");
		}
		
	
	}
	
	public static void main(String[] args) {
		runPetLogMenu();
	}
	
	public static void runPetLogMenu() {
		boolean again = true;
		System.out.println("Welcome to PetLog");
		while(again) {
			System.out.println("What would you like to do?");
			System.out.println("1. Add a new pet");
			System.out.println("2. Remove a pet");
			System.out.println("3. Edit a pet or owner");
			System.out.println("4. View a list of all pets");
			System.out.println("5. Exit PetLog");
			int userSelection = in.nextInt();
			in.nextLine();
			
			if(userSelection == 1) {
				addPet();
			}
			else if(userSelection == 2) {
				removePet();
			}
			else if(userSelection == 3) {
				editPet();
			}
			else if(userSelection == 4) {
				viewPetList();
			}
			else {
				ph.cleanUp();
				System.out.println("***Now exiting PetLog, have a great day***");
				again = false;
			}
			
			
			
		}
	}

}
