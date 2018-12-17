package fr.formation.proxibanquev3.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxibanquev3.metier.entity.Account;
import fr.formation.proxibanquev3.metier.service.AccountService;



/**
 * Classe permettant d'acceder � la page d'edition des informations d'un client.
 *  * @author Adminl
 *
 */
public class MenuServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	/**
	 * Methode permettant d'acceder a� menu.jsp.
	 * Recupere l'id du client dans la requete, et renvoie en attribut dans la reponse un objet client obtenu par la fonction read de client service.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idClient = Integer.parseInt(req.getParameter("id"));
		List<Account> accounts=AccountService.getInstance().getAll(idClient);
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(req, resp);
	}
	
}
