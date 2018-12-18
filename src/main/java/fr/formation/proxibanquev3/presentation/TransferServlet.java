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
 * Classe permettant de gerer les transferts
 * d'argent entre les comptes d'un même client. permet de faire un virement si le client possède au moins 2 comptes.
 * 
 * @author Jessica Di Marco & Sandy Colin
 *
 */

public class TransferServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TransferServlet.class);

	/**
	 * Methode permettant d'acceder à la page de transfer.jsp. Recupere l'id du
	 * client de la requete pour agir sur ses comptes specifiquement. Renvoie en
	 * attribut une liste des comptes dudit client. 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idClient = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(idClient);
		List<Account> accounts = AccountService.getInstance().getAll(idClient);
		req.setAttribute("accounts", accounts);
		req.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
		}
	
	
	/**
     * Methode renvoyant les informations des comptes utilises pour le transfert ainsi que le montant du
     * transfert choisi par l'utilisateur. Si le transfert echoue dans la methode
     * transfer() de AccountService, affiche un message d'erreur a l'utilisateur.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer compteCredite = Integer.parseInt(req.getParameter("compteACrediter"));
        Integer compteDebite = Integer.parseInt(req.getParameter("compteADebiter"));
        Integer clientId = Integer.parseInt(req.getParameter("id"));
        Float val = Float.parseFloat(req.getParameter("value"));

        Boolean transferOK = AccountService.getInstance().transfer(val, compteDebite, compteCredite, clientId);
        String message = "Le virement ne peut pas avoir lieu. Soit le montant est supérieur au solde disponible ou supérieur à 900€, soit vous avez mis le même compte en débiteur et créditeur ";
        
        if (!transferOK) {
        	TransferServlet.LOGGER.info(message);
        	req.setAttribute("message", message);
    		this.doGet(req, resp);
        } else {
            this.doGet(req,resp);
        }
    }
}
