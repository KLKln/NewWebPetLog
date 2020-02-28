package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.Pet;
import model.PetList;

/**
 * Servlet implementation class createNewPetListServlet
 */
@WebServlet("/createNewPetListServlet")
public class createNewPetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewPetListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PetHelper ph = new PetHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String ownerName = request.getParameter("ownerName");
		
		String[] selectedPets = request.getParameterValues("allPetsToAdd");
		List<Pet> selectedPetsInList = new ArrayList<Pet>();
		
		if(selectedPets !=null && selectedPets.length > 0) {
			for(int i = 0; i < selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				Pet p = ph.searchForPetById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(p);
			}
		}
		
		Owner owner = new Owner(ownerName);
		PetList spl = new PetList(listName, owner);
		spl.setListOfPets(selectedPetsInList);
		OwnerPetDetailsHelper opdh = new OwnerPetDetailsHelper();
		opdh.insertNewPetListDetails(spl);
		
		System.out.println("Success!");
		System.out.println(spl.toString());
		
		getServletContext().getRequestDispatcher("/viewAllPetListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
