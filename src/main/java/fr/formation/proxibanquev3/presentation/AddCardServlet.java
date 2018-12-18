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

public class AddCardServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer idClient = Integer.parseInt(req.getParameter("id"));
		Client client =ClientService.getInstance().read(idClient);
		req.setAttribute("client", client);
		List<Account> accounts=AccountService.getInstance().getAllCurrentAccounts(idClient);
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/addCard.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer accountId = Integer.parseInt(req.getParameter("compteADebiter"));
		if (AccountService.getInstance().withdrawCard(accountId, "premier")) {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/menu.html?id=" );			
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/card_error.jsp").forward(req, resp);
		}
	}
	

}
