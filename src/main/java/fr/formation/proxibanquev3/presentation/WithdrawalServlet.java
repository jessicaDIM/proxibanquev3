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
 * Classe permettant d'acceder à la page de retrait d'un client.
 *  * @author Jessica Di Marco & Sandy Colin
 *
 */
public class WithdrawalServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	/**
	 * Methode permettant d'acceder au withdrawal.jsp.
	 * Recupere l'id du client dans la requete, et renvoie en attribut dans la reponse un objet client obtenu par la fonction read de client service.
	 * et une liste d'objets accounts obtenue par la fonction getAll
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idClient = Integer.parseInt(req.getParameter("id"));
		Client client =ClientService.getInstance().read(idClient);
		req.setAttribute("client", client);
		List<Account> accounts=AccountService.getInstance().getAll(idClient);
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/withdrawal.jsp").forward(req, resp);
	}
	
	
	
}
