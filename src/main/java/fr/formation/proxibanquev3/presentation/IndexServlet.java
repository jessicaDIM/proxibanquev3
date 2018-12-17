package fr.formation.proxibanquev3.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxibanquev3.metier.entity.Client;
import fr.formation.proxibanquev3.metier.service.ClientService;

/**
 * Classe permettant de gerer l'affichage de l'ecran d'accueil de l'application.
 * @author Adminl
 *
 */
public class IndexServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * Methode permettant d'acceder a� index.jsp.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String identifiant = req.getParameter("identifiant");
		String[] parts = identifiant.split(" ");
		String firstnameClient = parts[0]; 
		String lastnameClient = parts[1];
	
		Client client = ClientService.getInstance().read(firstnameClient, lastnameClient);
		
		if (client != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(req, resp);			
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);	
		}
	}
}