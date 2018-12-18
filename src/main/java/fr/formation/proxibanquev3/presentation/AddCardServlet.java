package fr.formation.proxibanquev3.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.formation.proxibanquev3.metier.entity.Account;
import fr.formation.proxibanquev3.metier.entity.Client;
import fr.formation.proxibanquev3.metier.service.AccountService;
import fr.formation.proxibanquev3.metier.service.ClientService;

public class AddCardServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AddCardServlet.class);

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
		String accountIdNull = req.getParameter("compteADebiter");
		Integer clientId = Integer.parseInt(req.getParameter("id"));
		String cardType = req.getParameter("cardType");
		 String message2="Vous n'avez pas sélectionné de compte";
		 String message3="Vous n'avez pas sélectionné de type de carte";
	     if (accountIdNull==null) {
	    	 AddCardServlet.LOGGER.info(message2);
	           req.setAttribute("message1", message2);
	           this.doGet(req, resp);
	       }
	     if (cardType==null) {
	    	 AddCardServlet.LOGGER.info(message3);
	           req.setAttribute("message2", message3);
	           this.doGet(req, resp);
	       }
	    
	     Integer accountId = Integer.parseInt(req.getParameter("compteADebiter"));
		if (AccountService.getInstance().withdrawCard(accountId, cardType)) {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/menu.html?id=" + clientId);			
		} else {
			Client client =ClientService.getInstance().read(clientId);
			req.setAttribute("client", client);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/card_error.jsp").forward(req, resp);
		}
	}
	
}
