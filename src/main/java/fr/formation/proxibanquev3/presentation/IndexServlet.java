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
 * @author Jessica Di Marco & Sandy Colin
 *
 */
public class IndexServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * Methode permettant d'acceder à index.jsp.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
	
	/**
	 * Méthode permettant de récupérer le nom et le prénom du client puis de le relier à son Id pour le redirigé s'il existe vers la page menu.html
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String identifiant = req.getParameter("identifiant");
		if(identifiant==null || identifiant.isEmpty()) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp); }
		String[] parts = identifiant.split(" ");
		String firstnameClient = parts[0]; 
		String lastnameClient = parts[1];
		
		Client client = ClientService.getInstance().read(firstnameClient, lastnameClient);
		
		if (client == null) {
			client=ClientService.getInstance().read(lastnameClient, firstnameClient);
			if (client==null) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			}
		}
		Integer id= client.getId();
		resp.sendRedirect(this.getServletContext().getContextPath() + "/menu.html?id="+id);
	}
}