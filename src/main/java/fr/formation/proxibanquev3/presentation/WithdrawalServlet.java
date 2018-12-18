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

/**
 * Classe permettant d'acceder à la page de retrait d'un client.
 *  * @author Jessica Di Marco & Sandy Colin
 *
 */
public class WithdrawalServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(WithdrawalServlet.class);
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
		List<Account> accounts=AccountService.getInstance().getAllCurrentAccounts(idClient);
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/withdrawal.jsp").forward(req, resp);
	}
	/**
     * Methode renvoyant les informations des comptes utilises pour le transfert ainsi que le montant du
     * transfert choisi par l'utilisateur. Si le transfert echoue dans la methode
     * transfer() de ClientService, affiche un message d'erreur a l'utilisateur.
     */
   
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String compteADebiteNull = req.getParameter("compteADebiter");
        Integer clientId = Integer.parseInt(req.getParameter("id"));
        Float val = Float.parseFloat(req.getParameter("value"));
        String message2="Vous n'avez pas sélectionné de compte";
        if (compteADebiteNull==null) {
        	WithdrawalServlet.LOGGER.info(message2);
        	req.setAttribute("message1", message2);
    		this.doGet(req, resp);
        }
        Integer compteADebite = Integer.parseInt(req.getParameter("compteADebiter"));
        Boolean withdrawalOK = AccountService.getInstance().withdrawCash(val, compteADebite);
        String message1 = "Le retrait ne peut pas avoir lieu. Soit le montant est supérieur au solde disponible, soit il est supérieur à 300€ ";
        
        
      if (!withdrawalOK) {
        	WithdrawalServlet.LOGGER.info(message1);
        	req.setAttribute("message", message1);
    		this.doGet(req, resp);
        } else {
        	resp.sendRedirect(this.getServletContext().getContextPath() + "/menu.html?id="+clientId);
        }
    }
	
	
}
