package fr.formation.proxibanquev3.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxibanquev3.metier.entity.Account;
import fr.formation.proxibanquev3.metier.entity.Client;
import fr.formation.proxibanquev3.metier.service.AccountService;
import fr.formation.proxibanquev3.metier.service.ClientService;



/**
 * Classe permettant d'acceder � la page d'edition des informations d'un client.
 *  * @author Adminl
 *
 */
public class MenuServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	/**
	 * Methode permettant d'acceder au menu.jsp.
	 * Recupere l'id du client dans la requete, et renvoie en attribut dans la reponse un objet client obtenu par la fonction read de client service.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idClient = Integer.parseInt(req.getParameter("id"));
		Client client =ClientService.getInstance().read(idClient);
		req.setAttribute("client", client);
		List<Account> accounts=AccountService.getInstance().getAll(idClient);
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idClient=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("id", idClient);
		String action=req.getParameter("action1");
		switch(action) {
		case "index" : 
			resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html?id="+idClient);
			break;
		case "withdrawal" :
			resp.sendRedirect(this.getServletContext().getContextPath() + "/withdrawal.html?id="+idClient);
			break;
		case "transfer" :
			resp.sendRedirect(this.getServletContext().getContextPath() + "/transfer.html?id="+idClient);
			break;
		}
	}
}
